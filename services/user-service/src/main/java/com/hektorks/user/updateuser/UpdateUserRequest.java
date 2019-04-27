/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Null;

@Data
@ToString
class UpdateUserRequest {
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String phoneNumber;
  private String countryCode;

  boolean isNotEmpty() {
    return firstName != null ||
        lastName != null ||
        username != null ||
        email != null ||
        phoneNumber != null ||
        countryCode != null;
  }
}