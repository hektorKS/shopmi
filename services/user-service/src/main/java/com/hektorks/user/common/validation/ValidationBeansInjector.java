/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ValidationBeansInjector {

  @Bean
  FirstNameBusinessValidatorBean getFirstNameValidatorBean() {
    return new FirstNameBusinessValidatorBean();
  }

  @Bean
  LastNameBusinessValidatorBean getLastNameValidatorBean() {
    return new LastNameBusinessValidatorBean();
  }

  @Bean
  UsernameBusinessValidatorBean getUsernameValidatorBean() {
    return new UsernameBusinessValidatorBean();
  }

  @Bean
  EmailBusinessValidatorBean getEmailValidatorBean() {
    return new EmailBusinessValidatorBean();
  }

  @Bean
  PasswordBusinessValidatorBean getPasswordValidatorBean() {
    return new PasswordBusinessValidatorBean();
  }

  @Bean
  PhoneNumberBusinessValidatorBean getPhoneNumberValidatorBean() {
    return new PhoneNumberBusinessValidatorBean();
  }

  @Bean
  CountryCodeBusinessValidatorBean getCountryCodeValidatorBean() {
    return new CountryCodeBusinessValidatorBean();
  }

}
