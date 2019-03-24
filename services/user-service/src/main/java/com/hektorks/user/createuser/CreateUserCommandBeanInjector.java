package com.hektorks.user.createuser;

import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class CreateUserCommandBeanInjector {

  private final PasswordEncryptionBean passwordEncryptionBean;
  private final CreateUserRequestValidatorBean createUserRequestValidatorBean;
  private final UsersRepository usersRepository;

  @Bean(name = "CreateUserCommandBeanImpl")
  CreateUserCommandBeanImpl getCreateUserCommandBeanImpl() {
    return new CreateUserCommandBeanImpl(
        passwordEncryptionBean,
        createUserRequestValidatorBean,
        usersRepository
    );
  }
}
