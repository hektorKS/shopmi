/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common;

import com.hektorks.user.common.passwordencryption.EncryptedPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private EncryptedPassword encryptedPassword;
  private String email;
  private String phoneNumber;
  private String countryCode;
}
