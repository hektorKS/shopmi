/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import com.hektorks.dashboard.common.model.UsernameAvailability;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class UsernameAvailabilityResponse {
  private final String username;
  private final Boolean isAvailable;

  static UsernameAvailabilityResponse create(UsernameAvailability usernameAvailability) {
    return new UsernameAvailabilityResponse(
        usernameAvailability.getUsername(),
        usernameAvailability.isAvailable()
    );
  }
}