package com.hektorks.user.common.passwordencryption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EncryptedPassword {
  private byte[] password;
  private byte[] salt;
}
