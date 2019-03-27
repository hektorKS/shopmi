/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser.exceptions;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class UsernameExistsException extends BusinessValidationException {
  public UsernameExistsException(String username) {
    super("User with username " + username + " already exists.", "username");
  }
}
