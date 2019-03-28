/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
class UserAuthenticationRequest {
  @NotNull(message = "Mandatory field username missing.")
  private String username;
  @NotNull(message = "Mandatory field password missing.")
  private String password;

  @Override
  public String toString() {
    return "UserAuthenticationRequest{" +
        "username='" + username + '\'' +
        ", password='XXX'" +
        '}';
  }
}
