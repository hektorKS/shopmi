package com.hektorks.user.updateuser;

import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.userexists.UserExistsCommandBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UpdateUserByIdCommandBeanInjector {

  private final UpdateUserRequestValidatorBean updateUserRequestValidatorBean;
  private final UserExistsCommandBean userExistsCommandBean;
  private final UsersRepository usersRepository;

  @Bean
  UpdateUserByIdCommandBean getUpdateUserByIdCommandBean() {
    return new UpdateUserByIdCommandBeanImpl(
        updateUserRequestValidatorBean,
        userExistsCommandBean,
        usersRepository
    );
  }
}
