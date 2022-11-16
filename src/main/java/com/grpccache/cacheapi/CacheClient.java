/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grpccache.cacheapi;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CacheClient {
  private static final Logger logger = Logger.getLogger(CacheClient.class.getName());

  private final CacheApiHandlerGrpc.CacheApiHandlerBlockingStub blockingStub;

  /** Construct client for accessing HelloWorld server using the existing channel. */
  public CacheClient(Channel channel) {

    // 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
    // shut it down.

    // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
    blockingStub = CacheApiHandlerGrpc.newBlockingStub(channel);
  }

  /**
   * Greet server. If provided, the first element of {@code args} is the name to use in the
   * greeting. The second argument is the target server.
   */
  public static void main(String[] args) throws Exception {
    String key = "MANU";
    // Access a service running on the local machine on port 50051
    String target = "localhost:50051";
    // Allow passing in the key and target strings as command line arguments
    if (args.length > 0) {
      if ("--help".equals(args[0])) {
        System.err.println("Usage: [name [target]]");
        System.err.println();
        System.err.println("  name    The name you wish to be greeted by. Defaults to " + key);
        System.err.println("  target  The server to connect to. Defaults to " + target);
        System.exit(1);
      }
      key = args[0];
    }
    if (args.length > 1) {
      target = args[1];
    }

    // Create a communication channel to the server, known as a Channel. Channels are thread-safe
    // and reusable. It is common to create channels at the beginning of your application and reuse
    // them until the application shuts down.
    ManagedChannel channel =
        ManagedChannelBuilder.forTarget(target)
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
            // needing certificates.
            .usePlaintext()
            .build();
    try {
      CacheClient client = new CacheClient(channel);
      client.sendKey(key);
    } finally {
      // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
      // resources the channel should be shut down when it will no longer be used. If it may be used
      // again leave it running.
      channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
    }
  }

  /** Say hello to server. */
  public void sendKey(String key) {
    logger.info("Key " + key + " ...");

    ValueReply response = null;

    try {

      for (int i = 0; i < 10; i++) {
        KeyRequest request = KeyRequest.newBuilder().setKey(key + i).build();
        response = blockingStub.getValue(request);
        logger.info("Received from Server: " + response.getValue());
      }
    } catch (StatusRuntimeException e) {
      logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
      return;
    }
  }
}
