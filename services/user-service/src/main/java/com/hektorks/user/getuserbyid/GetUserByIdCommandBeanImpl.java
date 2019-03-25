package com.hektorks.user.getuserbyid;

import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.user.common.User;
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
      User user = usersRepository.getUserById(userId);
      if (user == null) {
        throw new ResourceNotFoundException();
      }
      return user;
    } catch (ResourceNotFoundException exception) {
      log.info("User not found for id [{}]", userId);
      throw exception;
    } catch (Exception exception) {
      throw new GetUserByIdCommandException(userId, exception);
    }
  }
}
