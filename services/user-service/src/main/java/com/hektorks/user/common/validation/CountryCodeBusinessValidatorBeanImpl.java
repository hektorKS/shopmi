package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class CountryCodeBusinessValidatorBeanImpl implements CountryCodeBusinessValidatorBean {

  private static final int COUNTRY_CODE_LENGTH = 2;

  @Override
  public void validate(String countryCode) {
    if (!isCountryCodeValid(countryCode)) {
      throw new BusinessValidationException(
          "Country code must be in ISO 3166-1 alpha-2 format.",
          "countryCode"
      );
    }
  }

  @Override
  public boolean isApplicable(String countryCode) {
    return countryCode != null;
  }

  private boolean isCountryCodeValid(String countryCode) {
    return countryCode.length() == COUNTRY_CODE_LENGTH;
  }

}
