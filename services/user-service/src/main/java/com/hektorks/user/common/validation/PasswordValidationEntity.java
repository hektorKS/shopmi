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
}
