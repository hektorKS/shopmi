package com.hektorks.usercommon.passwordencryption;

public interface PasswordEncryptionBean {
  EncryptedPassword encrypt(String password);
  String decrypt(EncryptedPassword encryptedPassword);
}
