package com.hektorks.user.userexists;

import com.hektorks.user.common.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UserExistsCommandBeanInjector {

  private final UsersRepository usersRepository;

  @Bean
  UserExistsCommandBean getUserExistsCommandBean() {
    return new UserExistsCommandBeanImpl(usersRepository);
  }

}
