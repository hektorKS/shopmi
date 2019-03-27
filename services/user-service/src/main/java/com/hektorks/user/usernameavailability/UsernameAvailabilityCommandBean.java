/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import com.hektorks.user.common.CommandBean;

public interface UsernameAvailabilityCommandBean extends CommandBean<Boolean, String> {
  @Override
  Boolean execute(String username);
}