package com.hektorks.user.common.passwordencryption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EncryptedPassword {
  private final byte[] password;
  private final byte[] salt;
}
