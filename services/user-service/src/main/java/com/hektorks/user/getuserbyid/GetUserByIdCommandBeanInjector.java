package com.hektorks.user.getuserbyid;

import com.hektorks.user.common.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class GetUserByIdCommandBeanInjector {

  private final UsersRepository usersRepository;

  @Bean
  GetUserByIdCommandBean getGetUserByIdCommandBeanImpl() {
    return new GetUserByIdCommandBeanImpl(usersRepository);
  }
}
