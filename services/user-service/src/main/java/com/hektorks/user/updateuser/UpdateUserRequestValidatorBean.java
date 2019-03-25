package com.hektorks.user.updateuser;


import com.hektorks.user.common.validation.ApplicableBusinessValidatorBean;
import com.hektorks.user.common.validation.BusinessValidatorBean;
import com.hektorks.user.common.validation.CountryCodeBusinessValidatorBean;
import com.hektorks.user.common.validation.EmailBusinessValidatorBean;
import com.hektorks.user.common.validation.FirstNameBusinessValidatorBean;
import com.hektorks.user.common.validation.LastNameBusinessValidatorBean;
import com.hektorks.user.common.validation.PhoneNumberBusinessValidatorBean;
import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class UpdateUserRequestValidatorBean implements BusinessValidatorBean<UpdateUserRequest> {

  private final FirstNameBusinessValidatorBean firstNameValidatorBean;
  private final LastNameBusinessValidatorBean lastNameValidatorBean;
  private final UsernameBusinessValidatorBean usernameValidatorBean;
  private final EmailBusinessValidatorBean emailValidatorBean;
  private final PhoneNumberBusinessValidatorBean phoneNumberValidatorBean;
  private final CountryCodeBusinessValidatorBean countryCodeValidatorBean;

  @Override
  public void validate(UpdateUserRequest updateUserRequest) {
    validate(updateUserRequest.getFirstName(), firstNameValidatorBean);
    validate(updateUserRequest.getLastName(), lastNameValidatorBean);
    validate(updateUserRequest.getUsername(), usernameValidatorBean);
    validate(updateUserRequest.getEmail(), emailValidatorBean);
    validate(updateUserRequest.getPhoneNumber(), phoneNumberValidatorBean);
    validate(updateUserRequest.getCountryCode(), countryCodeValidatorBean);
  }

  private void validate(String field, ApplicableBusinessValidatorBean<String> applicableBusinessValidatorBean) {
    if (applicableBusinessValidatorBean.isApplicable(field)) {
      applicableBusinessValidatorBean.validate(field);
    }
  }
}