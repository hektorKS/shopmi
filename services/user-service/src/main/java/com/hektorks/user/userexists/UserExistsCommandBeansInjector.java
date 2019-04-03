/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

import com.hektorks.user.common.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UserExistsCommandBeansInjector {

  private final UsersRepository usersRepository;

  @Bean
  UserExistsCommandBean getUserExistsCommandBean() {
    return new UserExistsCommandBeanImpl(usersRepository);
  }

  @Bean
  UserExistsByUsernameCommandBean getUserExistsByUsernameCommandBean() {
    return new UserExistsByUsernameCommandBeanImpl(usersRepository);
  }

  @Bean
  UserExistsByEmailCommandBean getUserExistsByEmailCommandBean() {
    return new UserExistsByEmailCommandBeanImpl(usersRepository);
  }

}