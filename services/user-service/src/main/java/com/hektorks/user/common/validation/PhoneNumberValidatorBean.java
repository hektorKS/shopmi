package com.hektorks.user.createuser.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.user.common.BusinessValidatorBean;

class PhoneNumberValidatorBean implements BusinessValidatorBean<String> {

  private static final String PHONE_NUMBER_PATTERN = "^\\+?(?:[0-9 ]?){6,16}[0-9]$";

  @Override
  public void validate(String phoneNumber) {
    if (!isValidPattern(phoneNumber)) {
      throw new BusinessValidationException(
          new StringBuilder()
              .append("Phone number must match pattern ")
              .append(PHONE_NUMBER_PATTERN)
              .append(".")
              .toString(),
          "phoneNumber"
      );
    }
  }

  private boolean isValidPattern(String phoneNumber) {
    return phoneNumber.matches(PHONE_NUMBER_PATTERN);
  }

}
