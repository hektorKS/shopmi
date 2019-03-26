package com.hektorks.user.userexists;

import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.userexists.exceptions.UserExistsByEmailCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UserExistsByEmailCommandBeanImpl implements UserExistsByEmailCommandBean {

  private final UsersRepository usersRepository;

  @Override
  public Boolean execute(String email) {
    try {
      return usersRepository.userExistsByEmail(email);
    } catch (Exception exception) {
      log.warn("Checking user existence by email [{}] failed", email, exception);
      throw new UserExistsByEmailCommandException(email, exception);
    }
  }
}
