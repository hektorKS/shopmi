package com.hektorks.user.common.validation;

public interface EmailValidatorBean extends BusinessValidatorBean<String> {
  void validate(String email);
}
