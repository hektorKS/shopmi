/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.common.validation.PasswordBusinessValidatorBean;
import com.hektorks.user.getuserbyid.GetUserByIdCommandBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class ChangeUserPasswordCommandBeanInjector {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;
  private final GetUserByIdCommandBean getUserByIdCommandBean;
  private final PasswordBusinessValidatorBean passwordBusinessValidatorBean;

  @Bean
  ChangeUserPasswordCommandBean getChangeUserPasswordCommandBean() {
    return new ChangeUserPasswordCommandBeanImpl(
        usersRepository,
        passwordEncryptionBean,
        getUserByIdCommandBean,
        passwordBusinessValidatorBean
    );
  }
}