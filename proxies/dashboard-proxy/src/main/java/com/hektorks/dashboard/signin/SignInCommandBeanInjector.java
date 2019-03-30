/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import com.hektorks.security.tokenservice.TokenService;
import com.hektorks.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class SignInCommandBeanInjector {

  private final TokenService tokenService;
  private final UserService userService;

  @Bean
  SignInCommandBean getSignInCommandBean() {
    return new SignInCommandBeanImpl(
        tokenService,
        userService
    );
  }
}