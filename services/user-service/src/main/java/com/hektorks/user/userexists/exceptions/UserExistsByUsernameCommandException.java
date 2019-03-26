/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists.exceptions;

import com.hektorks.exceptionhandling.CommandException;

public class UserExistsByUsernameCommandException extends CommandException {
  public UserExistsByUsernameCommandException(String username, Throwable cause) {
    super("Checking if user with username [ " + username + " ] exists failed.", cause);
  }
}
