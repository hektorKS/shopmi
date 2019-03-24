package com.hektorks.user.common.passwordencryption;

import com.hektorks.consul.config.SecurityConfig;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.NoSuchAlgorithmException;

@Configuration
@AllArgsConstructor
class PasswordEncryptionInjector {

  private final SecurityConfig securityConfig;

  @Bean
  PasswordEncryptionBean getPasswordEncryptionBean() throws NoSuchAlgorithmException {
    return new PasswordEncryptionBeanImpl(securityConfig);
  }
}
