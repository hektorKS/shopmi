package com.hektorks.user.common.validation;

public interface CountryCodeBusinessValidatorBean extends ApplicableBusinessValidatorBean<String> {
  @Override
  boolean isApplicable(String data);

  @Override
  void validate(String data);
}
