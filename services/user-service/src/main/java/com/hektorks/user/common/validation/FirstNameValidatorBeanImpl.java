package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class FirstNameValidatorBeanImpl implements FirstNameValidatorBean {

  private static final int FIRST_NAME_MIN_LENGTH = 2;
  private static final int FIRST_NAME_MAX_LENGTH = 32;

  @Override
  public void validate(String firstName) {
    if (!isFirstNameValid(firstName)) {
      throw new BusinessValidationException(
          new StringBuilder()
              .append("First name must be from ")
              .append(FIRST_NAME_MIN_LENGTH)
              .append(" to ")
              .append(FIRST_NAME_MAX_LENGTH)
              .append(" signs long.")
              .toString(),
          "firstName"
      );
    }
  }

  private boolean isFirstNameValid(String firstName) {
    return firstName.length() >= FIRST_NAME_MIN_LENGTH && firstName.length() <= FIRST_NAME_MAX_LENGTH;
  }

}
