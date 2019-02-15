/*
 * Copyright (C) 2019 Lightbend Inc. <https://www.lightbend.com>
 */
package com.lightbend.lagom.hello.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;
import com.lightbend.lagom.hello.api.HelloService;

/**
 * The module that binds the HelloService so that it can be served.
 */
public class HelloModule extends AbstractModule implements ServiceGuiceSupport {
  @Override
  protected void configure() {
    bindService(HelloService.class, HelloServiceImpl.class);
  }
}
