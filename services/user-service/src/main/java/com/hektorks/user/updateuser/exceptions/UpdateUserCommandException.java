package com.hektorks.user.updateuser.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class UpdateUserCommandException extends CommandException {
  public UpdateUserCommandException(Throwable cause) {
    super("User updating failed.", cause);
  }
}
