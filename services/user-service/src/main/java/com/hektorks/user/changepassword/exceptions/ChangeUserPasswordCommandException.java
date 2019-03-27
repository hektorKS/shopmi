/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class ChangeUserPasswordCommandException extends CommandException {
  public ChangeUserPasswordCommandException(Throwable cause) {
    super("Changing user password failed.", cause);
  }
}
