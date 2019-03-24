package com.hektorks.user.common.validation;

public interface PhoneNumberValidatorBean extends BusinessValidatorBean<String> {
  void validate(String phoneNumber);
}
