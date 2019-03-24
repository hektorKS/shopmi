package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.BusinessValidatorBean;
import com.hektorks.user.common.validation.CountryCodeValidatorBean;
import com.hektorks.user.common.validation.EmailValidatorBean;
import com.hektorks.user.common.validation.FirstNameValidatorBean;
import com.hektorks.user.common.validation.LastNameValidatorBean;
import com.hektorks.user.common.validation.PhoneNumberValidatorBean;
import com.hektorks.user.common.validation.UsernameValidatorBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class CreateUserRequestValidatorBean implements BusinessValidatorBean<CreateUserRequest> {

  private final FirstNameValidatorBean firstNameValidatorBean;
  private final LastNameValidatorBean lastNameValidatorBean;
  private final UsernameValidatorBean usernameValidatorBean;
  private final PasswordValidatorBean passwordValidatorBean;
  private final EmailValidatorBean emailValidatorBean;
  private final PhoneNumberValidatorBean phoneNumberValidatorBean;
  private final CountryCodeValidatorBean countryCodeValidatorBean;

  @Override
  public void validate(CreateUserRequest createUserRequest) {
    firstNameValidatorBean.validate(createUserRequest.getFirstName());
    lastNameValidatorBean.validate(createUserRequest.getLastName());
    usernameValidatorBean.validate(createUserRequest.getUsername());
    passwordValidatorBean.validate(createUserRequest);
    emailValidatorBean.validate(createUserRequest.getEmail());
    if (createUserRequest.getPhoneNumber() != null) {
      phoneNumberValidatorBean.validate(createUserRequest.getPhoneNumber());
    }
    if (createUserRequest.getCountryCode() != null) {
      countryCodeValidatorBean.validate(createUserRequest.getCountryCode());
    }
  }
}
