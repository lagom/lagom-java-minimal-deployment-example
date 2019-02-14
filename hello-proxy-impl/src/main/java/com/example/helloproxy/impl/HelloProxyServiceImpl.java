/*
 * Copyright (C) 2019 Lightbend Inc. <https://www.lightbend.com>
 */
package com.example.helloproxy.impl;

import akka.NotUsed;
import com.example.hello.api.HelloService;
import com.example.helloproxy.api.HelloProxyService;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.typesafe.config.Config;

import javax.inject.Inject;
import java.util.UUID;

public class HelloProxyServiceImpl implements HelloProxyService {

  private final HelloService helloService;

  // Use a random UUID on the response as a poor man's node ID
  private final UUID uuid = UUID.randomUUID();
  private final Config config;

  @Inject
  public HelloProxyServiceImpl(HelloService helloService, Config config) {
    this.helloService = helloService;
    this.config = config;
  }

  @Override
  public ServiceCall<NotUsed, String> proxyViaHttp(String id) {
    return __ -> helloService.hello(id).invoke().thenApply(msg -> msg + " (via proxy node " + uuid + ")");
  }
}
