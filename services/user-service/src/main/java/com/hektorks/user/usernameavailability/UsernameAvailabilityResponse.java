/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class UsernameAvailabilityResponse {
  private final String username;
  private final boolean availability;
}