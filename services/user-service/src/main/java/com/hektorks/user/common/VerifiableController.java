/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common;

import com.hektorks.exceptionhandling.RequestValidationErrors;
import com.hektorks.exceptionhandling.RequestValidationException;
import org.springframework.validation.Errors;

public abstract class VerifiableController {
  protected void handleErrors(Errors errors) {
    if (errors.hasErrors()) {
      throw new RequestValidationException(RequestValidationErrors.fromContextErrors(errors));
    }
  }
}