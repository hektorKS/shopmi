package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.CountryCodeValidatorBean;
import com.hektorks.user.common.validation.EmailValidatorBean;
import com.hektorks.user.common.validation.FirstNameValidatorBean;
import com.hektorks.user.common.validation.LastNameValidatorBean;
import com.hektorks.user.common.validation.PhoneNumberValidatorBean;
import com.hektorks.user.common.validation.UsernameValidatorBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class ValidatorBeansInjector {

  private final FirstNameValidatorBean firstNameValidatorBean;
  private final LastNameValidatorBean lastNameValidatorBean;
  private final UsernameValidatorBean usernameValidatorBean;
  private final EmailValidatorBean emailValidatorBean;
  private final PhoneNumberValidatorBean phoneNumberValidatorBean;
  private final CountryCodeValidatorBean countryCodeValidatorBean;

  @Bean
  CreateUserRequestValidatorBean getCreateUserRequestValidatorBean() {
    return new CreateUserRequestValidatorBean(
        firstNameValidatorBean,
        lastNameValidatorBean,
        usernameValidatorBean,
        getPasswordValidatorBean(),
        emailValidatorBean,
        phoneNumberValidatorBean,
        countryCodeValidatorBean
    );
  }

  @Bean
  PasswordValidatorBean getPasswordValidatorBean() {
    return new PasswordValidatorBean();
  }
}
