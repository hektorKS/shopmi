package com.hektorks.user.common.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BusinessValidationBeansInjector {

  @Bean
  FirstNameValidatorBean getFirstNameValidatorBean() {
    return new FirstNameValidatorBeanImpl();
  }

  @Bean
  LastNameValidatorBean getLastNameValidatorBean() {
    return new LastNameValidatorBeanImpl();
  }

  @Bean
  UsernameValidatorBean getUsernameValidatorBean() {
    return new UsernameValidatorBeanImpl();
  }

  @Bean
  EmailValidatorBean getEmailValidatorBean() {
    return new EmailValidatorBeanImpl();
  }

  @Bean
  PhoneNumberValidatorBean getPhoneNumberValidatorBean() {
    return new PhoneNumberValidatorBeanImpl();
  }

  @Bean
  CountryCodeValidatorBean getCountryCodeValidatorBean() {
    return new CountryCodeValidatorBeanImpl();
  }

}
