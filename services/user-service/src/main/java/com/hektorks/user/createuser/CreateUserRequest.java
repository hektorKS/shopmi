/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;

import javax.validation.constraints.NotNull;

@Data
@ToString
class CreateUserRequest {
  @NotNull(message = "Mandatory field firstName missing.")
  private String firstName;
  @NotNull(message = "Mandatory field lastName missing.")
  private String lastName;
  @NotNull(message = "Mandatory field username missing.")
  private String username;
  @NotNull(message = "Mandatory field password missing.")
  @Exclude
  private String password;
  @NotNull(message = "Mandatory field email missing.")
  private String email;
  private String phoneNumber;
  private String countryCode;
}