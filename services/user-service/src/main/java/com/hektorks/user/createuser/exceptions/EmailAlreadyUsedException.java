/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser.exceptions;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class EmailAlreadyUsedException extends BusinessValidationException {
  public EmailAlreadyUsedException(String email) {
    super("Email " + email + " is already used.", "username");
  }
}
