package com.hektorks.user.createuser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CreateUserCommandBeanInjector {

  @Bean
  CreateUserCommandBean getCreateUserCommandBean() {
    return new CreateUserCommandBean();
  }
}
