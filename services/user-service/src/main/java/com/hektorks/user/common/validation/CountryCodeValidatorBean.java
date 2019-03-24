package com.hektorks.user.createuser.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.user.common.BusinessValidatorBean;

class CountryCodeValidatorBean implements BusinessValidatorBean<String> {

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

  private boolean isCountryCodeValid(String countryCode) {
    return countryCode.length() == COUNTRY_CODE_LENGTH;
  }

}
