package com.hektorks.passwordencryption;

public interface PasswordEncryptionBean {
  EncryptedPassword encrypt(String password);
  String decrypt(EncryptedPassword encryptedPassword);
}
