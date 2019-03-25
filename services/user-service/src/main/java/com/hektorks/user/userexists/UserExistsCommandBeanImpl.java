package com.hektorks.user.userexists;

import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.userexists.exceptions.UserExistsCommandException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class UserExistsCommandBeanImpl implements UserExistsCommandBean {

  private final UsersRepository usersRepository;

  @Override
  public Boolean execute(Integer userId) {
    try {
      return usersRepository.userExistsById(userId);
    } catch (Exception exception) {
      throw new UserExistsCommandException(userId, exception);
    }
  }
}
