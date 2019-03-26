/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser.exceptions;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class UserExistsException extends BusinessValidationException {
  public UserExistsException(String username) {
    super("User with username " + username + " already exists.", "username");
  }
}
