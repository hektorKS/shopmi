/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.userexists.UserExistsByEmailCommandBean;
import com.hektorks.user.userexists.UserExistsByUsernameCommandBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class CreateUserCommandBeanInjector {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;
  private final CreateUserRequestValidatorBean createUserRequestValidatorBean;
  private final UserExistsByEmailCommandBean userExistsByEmailCommandBean;
  private final UserExistsByUsernameCommandBean userExistsByUsernameCommandBean;

  @Bean
  CreateUserCommandBean getCreateUserCommandBeanImpl() {
    return new CreateUserCommandBeanImpl(
        usersRepository,
        passwordEncryptionBean,
        createUserRequestValidatorBean,
        userExistsByEmailCommandBean,
        userExistsByUsernameCommandBean
    );
  }
}
