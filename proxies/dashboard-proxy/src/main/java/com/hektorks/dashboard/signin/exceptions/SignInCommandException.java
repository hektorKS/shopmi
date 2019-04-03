/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class SignInCommandException extends CommandException {
  public SignInCommandException(Throwable cause) {
    super("User sign-in failed.", cause);
  }
}