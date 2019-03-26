package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class EmailBusinessValidatorBeanImpl implements EmailBusinessValidatorBean {

  private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

  @Override
  public void validate(String email) {
    if (!isValidPattern(email)) {
      throw new BusinessValidationException(
          "Email must match pattern " + EMAIL_PATTERN + ".",
          "firstName"
      );
    }
  }

  @Override
  public boolean isApplicable(String email) {
    return email != null;
  }

  private boolean isValidPattern(String email) {
    return email.matches(EMAIL_PATTERN);
  }
}
