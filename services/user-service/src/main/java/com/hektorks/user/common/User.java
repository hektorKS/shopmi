package com.hektorks.user.common;

import com.hektorks.user.common.passwordencryption.EncryptedPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final EncryptedPassword encryptedPassword;
  private final String email;
  private final String phoneNumber;
  private final String countryCode;
}
