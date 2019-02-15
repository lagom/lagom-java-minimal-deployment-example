/*
 * Copyright (C) 2019 Lightbend Inc. <https://www.lightbend.com>
 */
package com.lightbend.lagom.helloproxy.impl;

import com.lightbend.lagom.helloproxy.api.HelloProxyService;
import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.lightbend.lagom.hello.api.HelloService;

/**
 * The module that binds the HelloProxyService so that it can be served.
 */
public class HelloProxyModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    // Bind the HelloProxyService service
    bindService(HelloProxyService.class, HelloProxyServiceImpl.class);
    // Bind the HelloService client
    bindClient(HelloService.class);
  }
}
