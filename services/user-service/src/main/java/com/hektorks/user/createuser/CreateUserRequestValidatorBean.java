package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.BusinessValidatorBean;
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
class CreateUserRequestValidatorBean implements BusinessValidatorBean<CreateUserRequest> {

  private final FirstNameBusinessValidatorBean firstNameValidatorBean;
  private final LastNameBusinessValidatorBean lastNameValidatorBean;
  private final UsernameBusinessValidatorBean usernameValidatorBean;
  private final PasswordBusinessValidatorBean passwordValidatorBean;
  private final EmailBusinessValidatorBean emailValidatorBean;
  private final PhoneNumberBusinessValidatorBean phoneNumberValidatorBean;
  private final CountryCodeBusinessValidatorBean countryCodeValidatorBean;

  @Override
  public void validate(CreateUserRequest createUserRequest) {
    firstNameValidatorBean.isApplicable(createUserRequest.getUsername());
    firstNameValidatorBean.validate(createUserRequest.getFirstName());
    lastNameValidatorBean.validate(createUserRequest.getLastName());
    usernameValidatorBean.validate(createUserRequest.getUsername());
    emailValidatorBean.validate(createUserRequest.getEmail());
    validatePassword(createUserRequest);
    validatePhoneNumber(createUserRequest.getPhoneNumber());
    validateCountryCode(createUserRequest.getCountryCode());
  }

  private void validatePassword(CreateUserRequest createUserRequest) {
    PasswordValidationEntity passwordValidationEntity = new PasswordValidationEntity(
        createUserRequest.getPassword(),
        createUserRequest.getFirstName(),
        createUserRequest.getLastName(),
        createUserRequest.getUsername(),
        createUserRequest.getEmail(),
        createUserRequest.getPhoneNumber()
    );
    if (passwordValidatorBean.isApplicable(passwordValidationEntity)) {
      passwordValidatorBean.validate(passwordValidationEntity);
    }
  }

  private void validatePhoneNumber(String phoneNumber) {
    if (phoneNumberValidatorBean.isApplicable(phoneNumber)) {
      phoneNumberValidatorBean.validate(phoneNumber);
    }
  }

  private void validateCountryCode(String countryCode) {
    if (countryCodeValidatorBean.isApplicable(countryCode)) {
      countryCodeValidatorBean.validate(countryCode);
    }
  }
}
