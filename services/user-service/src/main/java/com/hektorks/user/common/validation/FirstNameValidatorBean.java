package com.hektorks.user.common.validation;

public interface FirstNameValidatorBean extends BusinessValidatorBean<String> {
  void validate(String firstName);
}
