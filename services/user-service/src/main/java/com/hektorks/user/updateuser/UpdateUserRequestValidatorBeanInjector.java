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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class UpdateUserRequestValidatorBeanInjector {

  private final FirstNameBusinessValidatorBean firstNameValidatorBean;
  private final LastNameBusinessValidatorBean lastNameValidatorBean;
  private final UsernameBusinessValidatorBean usernameValidatorBean;
  private final EmailBusinessValidatorBean emailValidatorBean;
  private final PhoneNumberBusinessValidatorBean phoneNumberValidatorBean;
  private final CountryCodeBusinessValidatorBean countryCodeValidatorBean;

  @Bean
  UpdateUserRequestValidatorBean getUpdateUserRequestValidatorBean() {
    return new UpdateUserRequestValidatorBeanImpl(
        firstNameValidatorBean,
        lastNameValidatorBean,
        usernameValidatorBean,
        emailValidatorBean,
        phoneNumberValidatorBean,
        countryCodeValidatorBean
    );
  }
}