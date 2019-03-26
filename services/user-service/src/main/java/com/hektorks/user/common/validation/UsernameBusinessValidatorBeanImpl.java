package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class UsernameBusinessValidatorBeanImpl implements UsernameBusinessValidatorBean {

  private static final int USERNAME_MIN_LENGTH = 2;
  private static final int USERNAME_MAX_LENGTH = 32;
  private static final String USERNAME_PATTERN = "^(?=\\S+$).*$";

  @Override
  public void validate(String username) {
    if (!isUsernameLengthValid(username) || !isPatternValid(username)) {
      throw new BusinessValidationException(
          "Username must be from " + USERNAME_MIN_LENGTH + " to " + USERNAME_MAX_LENGTH + " signs long. "
              + "It cannot contain white signs.",
          "username"
      );
    }
  }

  @Override
  public boolean isApplicable(String username) {
    return username != null;
  }

  private boolean isUsernameLengthValid(String username) {
    return username.length() >= USERNAME_MIN_LENGTH && username.length() <= USERNAME_MAX_LENGTH;
  }

  private boolean isPatternValid(String username) {
    return username.matches(USERNAME_PATTERN);
  }

}
