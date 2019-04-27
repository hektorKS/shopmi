/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class LastNameBusinessValidatorBean extends BusinessValidatorTemplateBean<String> {

  private static final int LAST_NAME_MIN_LENGTH = 2;
  private static final int LAST_NAME_MAX_LENGTH = 32;

  @Override
  boolean appliesTo(String lastName) {
    return lastName != null;
  }

  @Override
  void process(String lastName) {
    if (!isLastNameValid(lastName)) {
      throw new BusinessValidationException(
          "Last name must be from " + LAST_NAME_MIN_LENGTH + " to " + LAST_NAME_MAX_LENGTH + " signs long.",
          "lastName"
      );
    }
  }

  private boolean isLastNameValid(String lastName) {
    return lastName.length() >= LAST_NAME_MIN_LENGTH && lastName.length() <= LAST_NAME_MAX_LENGTH;
  }
}