/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class UsernameAvailabilityResponse {
  private final String username;
  private final Boolean isAvailable;

  static UsernameAvailabilityResponse create(String username, boolean isAvailable) {
    return new UsernameAvailabilityResponse(username, isAvailable);
  }
}