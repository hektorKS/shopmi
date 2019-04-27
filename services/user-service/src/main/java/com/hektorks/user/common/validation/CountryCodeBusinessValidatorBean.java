/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class CountryCodeBusinessValidatorBean extends BusinessValidatorTemplateBean<String> {

  private static final int COUNTRY_CODE_LENGTH = 2;

  @Override
  boolean appliesTo(String countryCode) {
    return countryCode != null;
  }

  @Override
  void process(String countryCode) {
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