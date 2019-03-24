package com.hektorks.user.createuser.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.user.common.BusinessValidatorBean;

class UsernameValidatorBean implements BusinessValidatorBean<String> {

  private static final int USERNAME_MIN_LENGTH = 2;
  private static final int USERNAME_MAX_LENGTH = 32;
  private static final String USERNAME_PATTERN = "^(?=\\S+$).*$";

  @Override
  public void validate(String username) {
    if (!isUsernameLengthValid(username) || !isPatternValid(username)) {
      throw new BusinessValidationException(
          new StringBuilder()
              .append("Username must be from ")
              .append(USERNAME_MIN_LENGTH)
              .append(" to ")
              .append(USERNAME_MAX_LENGTH)
              .append(" signs long. ")
              .append("It cannot contain white signs.")
              .toString(),
          "username"
      );
    }
  }

  private boolean isUsernameLengthValid(String username) {
    return username.length() >= USERNAME_MIN_LENGTH && username.length() <= USERNAME_MAX_LENGTH;
  }

  private boolean isPatternValid(String username) {
    return username.matches(USERNAME_PATTERN);
  }

}
