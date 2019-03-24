package com.hektorks.user.createuser.exceptions;

import com.hektorks.exceptionhandling.BusinessValidationException;

public class EmailAlreadyUsedException extends BusinessValidationException {
  public EmailAlreadyUsedException(String email) {
    super("Email " + email + " is already used.", "username");
  }
}
