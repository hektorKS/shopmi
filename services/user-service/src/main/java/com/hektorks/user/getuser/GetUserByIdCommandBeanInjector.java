package com.hektorks.user.getuser;

import com.hektorks.user.common.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class GetUserByIdCommandBeanInjector {

  private final UsersRepository usersRepository;

  @Bean(name = "GetUserByIdCommandBeanImpl")
  GetUserByIdCommandBeanImpl getGetUserByIdCommandBeanImpl() {
    return new GetUserByIdCommandBeanImpl(usersRepository);
  }
}
