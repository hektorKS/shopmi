package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class EmailValidatorBeanImpl implements EmailValidatorBean {

  private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

  @Override
  public void validate(String email) {
    if (!isValidPattern(email)) {
      throw new BusinessValidationException(
          new StringBuilder()
              .append("Email must match pattern ")
              .append(EMAIL_PATTERN)
              .append(".")
              .toString(),
          "firstName"
      );
    }
  }

  private boolean isValidPattern(String email) {
    return email.matches(EMAIL_PATTERN);
  }

}
