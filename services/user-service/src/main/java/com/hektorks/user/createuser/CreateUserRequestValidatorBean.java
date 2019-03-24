package com.hektorks.user.createuser.validation;

import com.hektorks.user.common.BusinessValidatorBean;
import com.hektorks.user.createuser.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CreateUserRequestValidatorBean implements BusinessValidatorBean<CreateUserRequest> {

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
    phoneNumberValidatorBean.validate(createUserRequest.getPhoneNumber());
    countryCodeValidatorBean.validate(createUserRequest.getCountryCode());
  }
}
