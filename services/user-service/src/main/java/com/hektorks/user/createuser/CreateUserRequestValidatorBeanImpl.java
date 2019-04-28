/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.CountryCodeBusinessValidatorBean;
import com.hektorks.user.common.validation.EmailBusinessValidatorBean;
import com.hektorks.user.common.validation.FirstNameBusinessValidatorBean;
import com.hektorks.user.common.validation.LastNameBusinessValidatorBean;
import com.hektorks.user.common.validation.PasswordBusinessValidatorBean;
import com.hektorks.user.common.validation.PasswordValidationEntity;
import com.hektorks.user.common.validation.PhoneNumberBusinessValidatorBean;
import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class CreateUserRequestValidatorBeanImpl implements CreateUserRequestValidatorBean {

  private final FirstNameBusinessValidatorBean firstNameValidatorBean;
  private final LastNameBusinessValidatorBean lastNameValidatorBean;
  private final UsernameBusinessValidatorBean usernameValidatorBean;
  private final PasswordBusinessValidatorBean passwordValidatorBean;
  private final EmailBusinessValidatorBean emailValidatorBean;
  private final PhoneNumberBusinessValidatorBean phoneNumberValidatorBean;
  private final CountryCodeBusinessValidatorBean countryCodeValidatorBean;

  @Override
  public void validate(CreateUserRequest createUserRequest) {
    firstNameValidatorBean.validate(createUserRequest.getFirstName());
    lastNameValidatorBean.validate(createUserRequest.getLastName());
    usernameValidatorBean.validate(createUserRequest.getUsername());
    passwordValidatorBean.validate(new PasswordValidationEntity(
        createUserRequest.getPassword(),
        createUserRequest.getFirstName(),
        createUserRequest.getLastName(),
        createUserRequest.getUsername(),
        createUserRequest.getEmail(),
        createUserRequest.getPhoneNumber()
    ));
    emailValidatorBean.validate(createUserRequest.getEmail());
    phoneNumberValidatorBean.validate(createUserRequest.getPhoneNumber());
    countryCodeValidatorBean.validate(createUserRequest.getCountryCode());
  }
}