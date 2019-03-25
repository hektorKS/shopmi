package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.CountryCodeBusinessValidatorBean;
import com.hektorks.user.common.validation.EmailBusinessValidatorBean;
import com.hektorks.user.common.validation.FirstNameBusinessValidatorBean;
import com.hektorks.user.common.validation.LastNameBusinessValidatorBean;
import com.hektorks.user.common.validation.PasswordBusinessValidatorBean;
import com.hektorks.user.common.validation.PhoneNumberBusinessValidatorBean;
import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class CreateUserRequestValidatorBeanInjector {

  private final FirstNameBusinessValidatorBean firstNameValidatorBean;
  private final LastNameBusinessValidatorBean lastNameValidatorBean;
  private final UsernameBusinessValidatorBean usernameValidatorBean;
  private final PasswordBusinessValidatorBean passwordValidatorBean;
  private final EmailBusinessValidatorBean emailValidatorBean;
  private final PhoneNumberBusinessValidatorBean phoneNumberValidatorBean;
  private final CountryCodeBusinessValidatorBean countryCodeValidatorBean;

  @Bean
  CreateUserRequestValidatorBean getCreateUserRequestValidatorBean() {
    return new CreateUserRequestValidatorBean(
        firstNameValidatorBean,
        lastNameValidatorBean,
        usernameValidatorBean,
        passwordValidatorBean,
        emailValidatorBean,
        phoneNumberValidatorBean,
        countryCodeValidatorBean
    );
  }
}
