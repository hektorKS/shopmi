/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class CreateUserCommandException extends CommandException {
  public CreateUserCommandException(Throwable cause) {
    super("User creation failed.", cause);
  }
}
