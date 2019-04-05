/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import com.hektorks.dashboard.common.CommandBean;
import com.hektorks.dashboard.common.model.UsernameAvailability;

interface UsernameAvailabilityCommandBean extends CommandBean<UsernameAvailability, UsernameAvailabilityRequest> {
  @Override
  UsernameAvailability execute(UsernameAvailabilityRequest createUserRequest);
}