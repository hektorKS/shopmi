package com.hektorks.user.userexists.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class UserExistsCommandException extends CommandException {
  public UserExistsCommandException(Integer userId, Throwable cause) {
    super("Checking if user with id [ " + userId + " ] exists failed.", cause);
  }
}
