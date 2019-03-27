/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword.exceptions;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class InvalidOldPasswordException extends BusinessValidationException {
  public InvalidOldPasswordException() {
    super("Given old password is not valid.", "password");
  }
}
