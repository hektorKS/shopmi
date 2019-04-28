/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.restclient;

import com.hektorks.consul.config.HttpConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@AllArgsConstructor
class RestClientInjector {

  private final HttpConfig httpConfig;

  @Bean
  RestTemplate getRestTemplate() {
    return new RestTemplateBuilder()
        .setConnectTimeout(Duration.of(httpConfig.getConnectTimeoutMilliseconds(), ChronoUnit.MILLIS))
        .setReadTimeout(Duration.of(httpConfig.getReadTimeoutMilliseconds(), ChronoUnit.MILLIS))
        .errorHandler(getRestClientErrorHandler())
        .build();
  }

  @Bean
  RestClientErrorHandler getRestClientErrorHandler() {
    return new RestClientErrorHandler();
  }
}