/*
 * Copyright (C) 2019 Lightbend Inc. <https://www.lightbend.com>
 */
package com.lightbend.lagom.hello.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.pathCall;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;


public interface HelloService extends Service {

  ServiceCall<NotUsed, String> hello(String id);

  @Override
  default Descriptor descriptor() {
    // @formatter:off
    return named("hello-lagom-minimal-service").withCalls(
        pathCall("/api/hello/:id",  this::hello)
      ).withAutoAcl(true);
    // @formatter:on
  }
}
