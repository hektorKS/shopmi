/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UserAuthenticationCommandBeanInjector {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;
  private final UsernameBusinessValidatorBean usernameBusinessValidatorBean;

  @Bean
  UserAuthenticationCommandBean getUserAuthenticationCommandBean() {
    return new UserAuthenticationCommandBeanImpl(
        usersRepository,
        passwordEncryptionBean,
        usernameBusinessValidatorBean
    );
  }
}