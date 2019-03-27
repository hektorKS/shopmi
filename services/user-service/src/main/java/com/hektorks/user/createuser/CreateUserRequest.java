/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
class CreateUserRequest {

  @NotNull(message = "Mandatory field firstName missing.")
  private String firstName;
  @NotNull(message = "Mandatory field lastName missing.")
  private String lastName;
  @NotNull(message = "Mandatory field username missing.")
  private String username;
  @NotNull(message = "Mandatory field password missing.")
  private String password;
  @NotNull(message = "Mandatory field email missing.")
  private String email;
  private String phoneNumber;
  private String countryCode;

  @Override
  public String toString() {
    return "CreateUserRequest{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        ", password='" + "XXX" + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + (phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null) + '\'' +
        ", countryCode='" + countryCode + '\'' +
        '}';
  }
}
