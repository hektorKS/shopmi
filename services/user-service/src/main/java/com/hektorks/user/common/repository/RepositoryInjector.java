/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository;

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
    return new UsersRepositoryImpl(sqlSessionTemplate);
  }

}
