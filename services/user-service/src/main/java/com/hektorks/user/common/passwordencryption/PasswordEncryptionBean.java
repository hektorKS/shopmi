package com.hektorks.user.common.passwordencryption;

public interface PasswordEncryptionBean {
  EncryptedPassword encrypt(String password);
  String decrypt(EncryptedPassword encryptedPassword);
}
