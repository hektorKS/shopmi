package com.hektorks.user.createuser.validation;

import com.hektorks.user.common.validation.CountryCodeValidatorBean;
import com.hektorks.user.common.validation.EmailValidatorBean;
import com.hektorks.user.common.validation.FirstNameValidatorBean;
import com.hektorks.user.common.validation.LastNameValidatorBean;
import com.hektorks.user.common.validation.PhoneNumberValidatorBean;
import com.hektorks.user.common.validation.UsernameValidatorBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ValidatorBeansInjector {

  @Bean
  CreateUserRequestValidatorBean getCreateUserRequestValidatorBean() {
    return new CreateUserRequestValidatorBean(
        getFirstNameValidatorBean(),
        getLastNameValidatorBean(),
        getUsernameValidatorBean(),
        getPasswordValidatorBean(),
        getEmailValidatorBean(),
        getPhoneNumberValidatorBean(),
        getCountryCodeValidatorBean()
    );
  }

  @Bean
  FirstNameValidatorBean getFirstNameValidatorBean() {
    return new FirstNameValidatorBean();
  }

  @Bean
  LastNameValidatorBean getLastNameValidatorBean() {
    return new LastNameValidatorBean();
  }

  @Bean
  UsernameValidatorBean getUsernameValidatorBean() {
    return new UsernameValidatorBean();
  }

  @Bean
  PasswordValidatorBean getPasswordValidatorBean() {
    return new PasswordValidatorBean();
  }

  @Bean
  EmailValidatorBean getEmailValidatorBean() {
    return new EmailValidatorBean();
  }

  @Bean
  PhoneNumberValidatorBean getPhoneNumberValidatorBean() {
    return new PhoneNumberValidatorBean();
  }

  @Bean
  CountryCodeValidatorBean getCountryCodeValidatorBean() {
    return new CountryCodeValidatorBean();
  }

}
