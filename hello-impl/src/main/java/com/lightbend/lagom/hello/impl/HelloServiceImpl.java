/*
 * Copyright (C) 2019 Lightbend Inc. <https://www.lightbend.com>
 */
package com.lightbend.lagom.hello.impl;

import akka.NotUsed;
import com.lightbend.lagom.hello.api.HelloService;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.UUID;

import static java.util.concurrent.CompletableFuture.completedFuture;

public class HelloServiceImpl implements HelloService {


    // Use a random UUID on the response as a poor man's node ID
    private UUID uuid = UUID.randomUUID();

    @Override
    public ServiceCall<NotUsed, String> hello(String id) {
        return __ -> completedFuture("Hi " + id + "! (at node " + uuid + ")");
    }
}
