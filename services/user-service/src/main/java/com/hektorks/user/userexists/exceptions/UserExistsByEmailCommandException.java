/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class UserExistsByEmailCommandException extends CommandException {
  public UserExistsByEmailCommandException(String username, Throwable cause) {
    super("Checking if user with email [ " + username + " ] exists failed.", cause);
  }
}
