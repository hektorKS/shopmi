/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class GetUserProfileCommandBeanInjector {

  private final UserService userService;

  @Bean
  GetUserProfileCommandBean getGetUserProfileCommandBean() {
    return new GetUserProfileCommandBeanImpl(userService);
  }
}