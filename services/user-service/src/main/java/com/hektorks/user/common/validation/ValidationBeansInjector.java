package com.hektorks.user.common.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ValidationBeansInjector {

  @Bean
  FirstNameBusinessValidatorBean getFirstNameValidatorBean() {
    return new FirstNameBusinessValidatorBeanImpl();
  }

  @Bean
  LastNameBusinessValidatorBean getLastNameValidatorBean() {
    return new LastNameBusinessValidatorBeanImpl();
  }

  @Bean
  UsernameBusinessValidatorBean getUsernameValidatorBean() {
    return new UsernameBusinessValidatorBeanImpl();
  }

  @Bean
  EmailBusinessValidatorBean getEmailValidatorBean() {
    return new EmailBusinessValidatorBeanImpl();
  }

  @Bean
  PasswordBusinessValidatorBean getPasswordValidatorBean() {
    return new PasswordBusinessValidatorBeanImpl();
  }

  @Bean
  PhoneNumberBusinessValidatorBean getPhoneNumberValidatorBean() {
    return new PhoneNumberBusinessValidatorBeanImpl();
  }

  @Bean
  CountryCodeBusinessValidatorBean getCountryCodeValidatorBean() {
    return new CountryCodeBusinessValidatorBeanImpl();
  }

}
