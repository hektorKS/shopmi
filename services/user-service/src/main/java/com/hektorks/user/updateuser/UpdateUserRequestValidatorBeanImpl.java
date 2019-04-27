/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;


import com.hektorks.user.common.validation.CountryCodeBusinessValidatorBean;
import com.hektorks.user.common.validation.EmailBusinessValidatorBean;
import com.hektorks.user.common.validation.FirstNameBusinessValidatorBean;
import com.hektorks.user.common.validation.LastNameBusinessValidatorBean;
import com.hektorks.user.common.validation.PhoneNumberBusinessValidatorBean;
import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class UpdateUserRequestValidatorBeanImpl implements UpdateUserRequestValidatorBean {

  private final FirstNameBusinessValidatorBean firstNameValidatorBean;
  private final LastNameBusinessValidatorBean lastNameValidatorBean;
  private final UsernameBusinessValidatorBean usernameValidatorBean;
  private final EmailBusinessValidatorBean emailValidatorBean;
  private final PhoneNumberBusinessValidatorBean phoneNumberValidatorBean;
  private final CountryCodeBusinessValidatorBean countryCodeValidatorBean;

  @Override
  public void validate(UpdateUserRequest updateUserRequest) {
    firstNameValidatorBean.validate(updateUserRequest.getFirstName());
    lastNameValidatorBean.validate(updateUserRequest.getLastName());
    usernameValidatorBean.validate(updateUserRequest.getUsername());
    emailValidatorBean.validate(updateUserRequest.getEmail());
    phoneNumberValidatorBean.validate(updateUserRequest.getPhoneNumber());
    countryCodeValidatorBean.validate(updateUserRequest.getCountryCode());
  }
}