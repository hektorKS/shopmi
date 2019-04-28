/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class FirstNameBusinessValidatorBean extends BusinessValidatorTemplateBean<String> {

  private static final int FIRST_NAME_MIN_LENGTH = 2;
  private static final int FIRST_NAME_MAX_LENGTH = 32;

  @Override
  boolean appliesTo(String firstName) {
    return firstName != null;
  }

  @Override
  void process(String firstName) {
    if (!isFirstNameValid(firstName)) {
      throw new BusinessValidationException(
          "First name must be from " + FIRST_NAME_MIN_LENGTH + " to " + FIRST_NAME_MAX_LENGTH + " signs long.",
          "firstName"
      );
    }
  }

  private boolean isFirstNameValid(String firstName) {
    return firstName.length() >= FIRST_NAME_MIN_LENGTH && firstName.length() <= FIRST_NAME_MAX_LENGTH;
  }
}