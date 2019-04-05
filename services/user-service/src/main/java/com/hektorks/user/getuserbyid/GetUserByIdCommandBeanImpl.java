/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.getuserbyid;

import com.hektorks.user.common.model.User;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.getuserbyid.exceptions.GetUserByIdCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class GetUserByIdCommandBeanImpl implements GetUserByIdCommandBean {

  private final UsersRepository usersRepository;

  @Override
  public User execute(Integer userId) {
    try {
      return usersRepository.getUserById(userId);
    } catch (Exception exception) {
      log.warn("Getting user failed", exception);
      throw new GetUserByIdCommandException(userId, exception);
    }
  }
}