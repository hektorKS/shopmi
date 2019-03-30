/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security.tokenservice;

import com.hektorks.consul.config.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class TokenServiceInjector {

  private final SecurityConfig securityConfig;

  @Bean
  TokenService getTokenService() {
    return new TokenServiceImpl(securityConfig);
  }
}