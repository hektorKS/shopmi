/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import com.hektorks.user.userexists.UserExistsByUsernameCommandBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UsernameAvailabilityCommandBeanInjector {

  private final UserExistsByUsernameCommandBean userExistsByUsernameCommandBean;
  private final UsernameBusinessValidatorBean usernameBusinessValidatorBean;

  @Bean
  UsernameAvailabilityCommandBean getUsernameAvailabilityCommandBean() {
    return new UsernameAvailabilityCommandBeanImpl(userExistsByUsernameCommandBean, usernameBusinessValidatorBean);
  }
}