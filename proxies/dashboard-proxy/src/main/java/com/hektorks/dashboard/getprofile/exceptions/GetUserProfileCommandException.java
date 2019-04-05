/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class GetUserProfileCommandException extends CommandException {
  public GetUserProfileCommandException(Integer userId, Throwable cause) {
    super("Getting user by id [" + userId + "] failed", cause);
  }
}