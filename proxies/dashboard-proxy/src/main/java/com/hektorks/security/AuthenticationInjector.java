/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security;

import com.hektorks.security.tokenservice.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;

import java.util.Collections;

@Configuration
@AllArgsConstructor
class AuthenticationInjector {

  private final TokenService tokenService;

  @Bean
  JWTAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
    return new JWTAuthenticationEntryPoint();
  }

  @Bean
  JWTAuthenticationProvider jwtAuthenticationProvider() {
    return new JWTAuthenticationProvider(tokenService);
  }

  @Bean
  AuthenticationManager authenticationManager() {
    return new ProviderManager(Collections.singletonList(jwtAuthenticationProvider()));
  }
}
