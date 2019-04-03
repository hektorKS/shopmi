/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.passwordencryption;

public interface PasswordEncryptionBean {
  EncryptedPassword encrypt(String password);

  String decrypt(EncryptedPassword encryptedPassword);
}