/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.getuserbyid.GetUserByIdCommandBean;
import com.hektorks.user.userexists.UserExistsByEmailCommandBean;
import com.hektorks.user.userexists.UserExistsByUsernameCommandBean;
import com.hektorks.user.userexists.UserExistsCommandBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UpdateUserByIdCommandBeanInjector {

  private final UserExistsByUsernameCommandBean userExistsByUsernameCommandBean;
  private final UserExistsByEmailCommandBean userExistsByEmailCommandBean;
  private final GetUserByIdCommandBean getUserByIdCommandBean;
  private final UpdateUserRequestValidatorBean updateUserRequestValidatorBean;
  private final UserExistsCommandBean userExistsCommandBean;
  private final UsersRepository usersRepository;

  @Bean
  UpdateUserByIdCommandBean getUpdateUserByIdCommandBean() {
    return new UpdateUserByIdCommandBeanImpl(
        userExistsByUsernameCommandBean,
        userExistsByEmailCommandBean,
        getUserByIdCommandBean,
        updateUserRequestValidatorBean,
        userExistsCommandBean,
        usersRepository
    );
  }
}
