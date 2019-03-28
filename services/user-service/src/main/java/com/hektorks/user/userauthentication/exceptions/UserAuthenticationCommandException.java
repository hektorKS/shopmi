/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class UserAuthenticationCommandException extends CommandException {
  public UserAuthenticationCommandException(Throwable cause) {
    super("User authentication process failed.", cause);
  }
}
