/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
class UsernameAvailabilityRequest {
  @NotNull(message = "Mandatory field username missing.")
  private String username;
}