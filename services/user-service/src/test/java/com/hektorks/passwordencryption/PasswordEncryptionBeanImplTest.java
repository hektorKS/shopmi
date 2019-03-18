package com.hektorks.passwordencryption;

import com.hektorks.consul.configuration.SecurityConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.security.NoSuchAlgorithmException;

@RunWith(MockitoJUnitRunner.class)
class PasswordEncryptionBeanImplTest {

  @Mock
  SecurityConfig securityConfig;

  private PasswordEncryptionBean passwordEncryptionBean;

  @BeforeEach
  void setup() throws NoSuchAlgorithmException {
    MockitoAnnotations.initMocks(this);
    Mockito.when(securityConfig.getEncryptionSecret()).thenReturn("01a5d9a4b507428ea08b0bd25e5d4539");
    passwordEncryptionBean = new PasswordEncryptionBeanImpl(securityConfig);
  }

  @Test
  void testEncryption() {
    // given
    String expected = "test-password-1";

    // when
    EncryptedPassword encryptedPassword = passwordEncryptionBean.encrypt(expected);
    String actual = passwordEncryptionBean.decrypt(encryptedPassword);

    // then
    Assertions.assertEquals(expected, actual);
  }
}