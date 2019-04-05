/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import com.hektorks.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UsernameAvailabilityCommandBeanInjector {

  private final UserService userService;

  @Bean
  UsernameAvailabilityCommandBean getUsernameAvailabilityCommandBean() {
    return new UsernameAvailabilityCommandBeanImpl(
        userService
    );
  }
}