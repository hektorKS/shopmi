package com.hektorks.user.common.validation;

public interface CountryCodeValidatorBean extends BusinessValidatorBean<String> {
  void validate(String countryCode);
}
