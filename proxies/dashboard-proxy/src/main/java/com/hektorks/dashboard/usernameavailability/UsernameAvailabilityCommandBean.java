/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import com.hektorks.dashboard.common.model.UsernameAvailability;

interface UsernameAvailabilityCommandBean {
  UsernameAvailability execute(UsernameAvailabilityRequest createUserRequest);
}