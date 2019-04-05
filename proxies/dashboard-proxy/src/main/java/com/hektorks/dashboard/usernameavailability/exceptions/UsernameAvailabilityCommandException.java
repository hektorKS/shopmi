/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class UsernameAvailabilityCommandException extends CommandException {
  public UsernameAvailabilityCommandException(String username, Throwable cause) {
    super("Checking username availability for username [" + username + "] failed.", cause);
  }
}