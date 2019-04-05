/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;

import javax.validation.constraints.NotNull;


@Data
@ToString
class UserAuthenticationRequest {
  @NotNull(message = "Mandatory field username missing.")
  private String username;
  @NotNull(message = "Mandatory field password missing.")
  @Exclude
  private String password;
}