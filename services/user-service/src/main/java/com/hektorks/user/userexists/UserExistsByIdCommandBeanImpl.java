/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.userexists.exceptions.UserExistsCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UserExistsByIdCommandBeanImpl implements UserExistsByIdCommandBean {

  private final UsersRepository usersRepository;

  @Override
  public Boolean execute(Integer userId) {
    try {
      return usersRepository.userExistsById(userId);
    } catch (Exception exception) {
      log.warn("Checking user existence by id [{}] failed", userId, exception);
      throw new UserExistsCommandException(userId, exception);
    }
  }
}