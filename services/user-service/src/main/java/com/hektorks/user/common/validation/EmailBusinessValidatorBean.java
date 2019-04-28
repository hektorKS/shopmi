/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class EmailBusinessValidatorBean extends BusinessValidatorTemplateBean<String> {

  private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

  @Override
  boolean appliesTo(String email) {
    return email != null;
  }

  @Override
  void process(String email) {
    if (!isValidPattern(email)) {
      throw new BusinessValidationException(
          "Email must match pattern " + EMAIL_PATTERN + ".",
          "firstName"
      );
    }
  }

  private boolean isValidPattern(String email) {
    return email.matches(EMAIL_PATTERN);
  }
}