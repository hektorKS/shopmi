/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

public interface UsernameAvailabilityCommandBean {
  Boolean execute(String username);
}