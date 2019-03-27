/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common;

import com.hektorks.user.common.passwordencryption.EncryptedPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        ", encryptedPassword=" + encryptedPassword +
        ", email='" + email + '\'' +
        ", phoneNumber='" + (phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null) + '\'' +
        ", countryCode='" + countryCode + '\'' +
        '}';
  }
}
