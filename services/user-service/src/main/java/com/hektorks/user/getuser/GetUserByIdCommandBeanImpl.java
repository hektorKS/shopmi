package com.hektorks.user.getuser;

import com.hektorks.user.common.CommandBean;
import com.hektorks.user.common.User;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.getuser.exceptions.GetUserByIdCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class GetUserByIdCommandBeanImpl implements CommandBean<User, Integer> {

  private final UsersRepository usersRepository;

  @Override
  public User execute(Integer userId) {
    try {
      return usersRepository.getUserById(userId);
    } catch (Exception exception) {
      throw new GetUserByIdCommandException(userId, exception);
    }
  }
}
