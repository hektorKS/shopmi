/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordValidationEntity {
  private final String password;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String email;
  private final String phoneNumber;

  @Override
  public String toString() {
    return "PasswordValidationEntity{" +
        "password='" + "XXX" + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + (phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null) + '\'' +
        '}';
  }
}