/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import lombok.AllArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@AllArgsConstructor
class UserServiceInjector {
  private final DiscoveryClient discoveryClient;
  private final RestTemplate restTemplate;

  @Bean
  UserService getUserService() {
    return new UserServiceImpl(
        discoveryClient,
        restTemplate
    );
  }
}