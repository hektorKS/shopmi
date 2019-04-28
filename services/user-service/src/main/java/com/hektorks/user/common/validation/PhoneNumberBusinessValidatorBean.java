/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class PhoneNumberBusinessValidatorBean extends BusinessValidatorTemplateBean<String> {

  private static final String PHONE_NUMBER_PATTERN = "^\\+?(?:[0-9 ]?){6,16}[0-9]$";

  @Override
  boolean appliesTo(String phoneNumber) {
    return phoneNumber != null;
  }

  @Override
  void process(String phoneNumber) {
    if (!isValidPattern(phoneNumber)) {
      throw new BusinessValidationException(
          "Phone number must match pattern " + PHONE_NUMBER_PATTERN + ".",
          "phoneNumber"
      );
    }
  }

  private boolean isValidPattern(String phoneNumber) {
    return phoneNumber.matches(PHONE_NUMBER_PATTERN);
  }

}