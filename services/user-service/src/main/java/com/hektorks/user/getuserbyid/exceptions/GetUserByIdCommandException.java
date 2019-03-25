package com.hektorks.user.getuserbyid.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class GetUserByIdCommandException extends CommandException {
  public GetUserByIdCommandException(Integer userId, Throwable cause) {
    super("Getting user by id [ " + userId + " ] failed.", cause);
  }
}
