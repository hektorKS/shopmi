/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.userexists.exceptions.UserExistsByUsernameCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UserExistsByUsernameCommandBeanImpl implements UserExistsByUsernameCommandBean {

  private final UsersRepository usersRepository;

  @Override
  public Boolean execute(String username) {
    try {
      return usersRepository.userExistsByUsername(username);
    } catch (Exception exception) {
      log.warn("Checking user existence by username [{}] failed", username, exception);
      throw new UserExistsByUsernameCommandException(username, exception);
    }
  }
}