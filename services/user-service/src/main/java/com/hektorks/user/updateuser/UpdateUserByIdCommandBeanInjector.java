package com.hektorks.user.updateuser;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UpdateUserByIdCommandBeanInjector {

  private final UpdateUserRequestValidatorBean updateUserRequestValidatorBean;

  @Bean
  UpdateUserByIdCommandBean getUpdateUserByIdCommandBean() {
    return new UpdateUserByIdCommandBeanImpl(updateUserRequestValidatorBean);
  }
}
