package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class PhoneNumberBusinessValidatorBeanImpl implements PhoneNumberBusinessValidatorBean {

  private static final String PHONE_NUMBER_PATTERN = "^\\+?(?:[0-9 ]?){6,16}[0-9]$";

  @Override
  public void validate(String phoneNumber) {
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

  @Override
  public boolean isApplicable(String phoneNumber) {
    return phoneNumber != null;
  }
}
