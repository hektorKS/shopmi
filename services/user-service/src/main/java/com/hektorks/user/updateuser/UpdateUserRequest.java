/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import lombok.Data;

import javax.validation.constraints.Null;

@Data
class UpdateUserRequest {
  @Null
  private Integer userId;
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

  @Override
  public String toString() {
    return "UpdateUserRequest{" +
        "userId=" + userId +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + (phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null) + '\'' +
        ", countryCode='" + countryCode + '\'' +
        '}';
  }
}
