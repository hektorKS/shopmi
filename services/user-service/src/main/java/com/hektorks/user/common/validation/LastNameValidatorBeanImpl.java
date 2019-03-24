package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class LastNameValidatorBean implements FirstNameValidatorBean {

  private static final int LAST_NAME_MIN_LENGTH = 2;
  private static final int LAST_NAME_MAX_LENGTH = 32;

  @Override
  public void validate(String lastName) {
    if (!isLastNameValid(lastName)) {
      throw new BusinessValidationException(
          new StringBuilder()
              .append("Last name must be from ")
              .append(LAST_NAME_MIN_LENGTH)
              .append(" to ")
              .append(LAST_NAME_MAX_LENGTH)
              .append(" signs long.")
              .toString(),
          "lastName"
      );
    }
  }

  private boolean isLastNameValid(String lastName) {
    return lastName.length() >= LAST_NAME_MIN_LENGTH && lastName.length() <= LAST_NAME_MAX_LENGTH;
  }

}
