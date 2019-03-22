package com.hektorks.usercommon.passwordencryption;

import com.hektorks.consul.config.SecurityConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;


@ExtendWith(MockitoExtension.class)
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