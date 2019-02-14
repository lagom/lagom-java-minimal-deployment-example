/*
 * Copyright (C) 2019 Lightbend Inc. <https://www.lightbend.com>
 */
package com.example.helloproxy.api;

import static com.lightbend.lagom.javadsl.api.Service.named;
import static com.lightbend.lagom.javadsl.api.Service.restCall;

import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;


public interface HelloProxyService extends Service {

  ServiceCall<NotUsed, String> proxyViaHttp(String id);

  @Override
  default Descriptor descriptor() {
    return named("hello-proxy-lagom-minimal-service")
            .withCalls(
              restCall(Method.GET, "/proxy/rest-hello/:id", this::proxyViaHttp)
            ).withAutoAcl(true);
  }
}
