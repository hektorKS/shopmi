/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import com.hektorks.user.userexists.UserExistsByUsernameCommandBean;
import com.hektorks.user.usernameavailability.exceptions.UsernameAvailabilityCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UsernameAvailabilityCommandBeanImpl implements UsernameAvailabilityCommandBean {

  private final UserExistsByUsernameCommandBean userExistsByUsernameCommandBean;
  private final UsernameBusinessValidatorBean usernameBusinessValidatorBean;

  @Override
  public Boolean execute(String username) {
    try {
      usernameBusinessValidatorBean.validate(username);
      return !(userExistsByUsernameCommandBean.execute(username));
    } catch (Exception exception) {
      log.warn("Checking username availability [{}] failed", username, exception);
      throw new UsernameAvailabilityCommandException(username, exception);
    }
  }
}