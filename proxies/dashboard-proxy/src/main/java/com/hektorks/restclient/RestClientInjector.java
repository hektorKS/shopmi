/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.restclient;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
class RestClientInjector {

  @Bean
  RestTemplate getRestTemplate() {
    return new RestTemplateBuilder()
        .errorHandler(getRestClientErrorHandler())
        .build();
  }

  @Bean
  RestClientErrorHandler getRestClientErrorHandler() {
    return new RestClientErrorHandler();
  }
}
