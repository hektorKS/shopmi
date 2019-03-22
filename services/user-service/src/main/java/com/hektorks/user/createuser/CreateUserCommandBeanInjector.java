package com.hektorks.user.createuser;

import com.hektorks.usercommon.repository.UsersRepository;
import com.hektorks.usercommon.passwordencryption.PasswordEncryptionBean;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
class CreateUserCommandBeanInjector {

  private final PasswordEncryptionBean passwordEncryptionBean;
  private final UsersRepository usersRepository;

  @Bean(name = "CreateUserCommandBean")
  CreateUserCommandBean getCreateUserCommandBean() {
    return new CreateUserCommandBean(usersRepository, passwordEncryptionBean);
  }
}
