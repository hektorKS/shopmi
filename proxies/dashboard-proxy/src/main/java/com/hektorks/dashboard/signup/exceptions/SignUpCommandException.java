/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class SignUpCommandException extends CommandException {
  public SignUpCommandException(Throwable cause) {
    super("User sign up failed.", cause);
  }
}