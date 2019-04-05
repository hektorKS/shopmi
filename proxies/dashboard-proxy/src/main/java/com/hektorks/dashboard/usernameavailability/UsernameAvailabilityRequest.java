/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class UsernameAvailabilityRequest {
  @NotNull(message = "Mandatory field username missing.")
  private String username;
}