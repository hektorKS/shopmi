package com.hektorks.usercommon.repository;

import lombok.AllArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class RepositoryInjector {

  private final SqlSessionTemplate sqlSessionTemplate;

  @Bean
  UsersRepository getUsersRepository() {
    return new UsersRepository(sqlSessionTemplate);
  }

}
