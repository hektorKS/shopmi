/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;

@Data
@ToString
@AllArgsConstructor
public class PasswordValidationEntity {
  @Exclude
  private final String password;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String email;
  private final String phoneNumber;
}