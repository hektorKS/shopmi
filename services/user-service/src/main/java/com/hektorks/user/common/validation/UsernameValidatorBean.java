package com.hektorks.user.common.validation;

public interface UsernameValidatorBean extends BusinessValidatorBean<String> {
  void validate(String username);
}
