package com.hektorks.user.common.validation;

public interface UsernameBusinessValidatorBean extends ApplicableBusinessValidatorBean<String> {
  @Override
  boolean isApplicable(String data);

  @Override
  void validate(String data);
}
