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
  private Integer id;
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
    return new StringBuilder()
        .append("UpdateUserRequest(")
        .append("firstName = ")
        .append(firstName)
        .append(", ")
        .append("lastName = ")
        .append(lastName)
        .append(", ")
        .append("username = ")
        .append(username)
        .append(", ")
        .append("email = ")
        .append(email)
        .append(", ")
        .append("phoneNumber = ")
        .append(phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null)
        .append(", ")
        .append("countryCode = ")
        .append(countryCode)
        .append(")")
        .toString();
  }
}
