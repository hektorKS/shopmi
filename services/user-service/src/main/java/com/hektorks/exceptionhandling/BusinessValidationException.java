/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessValidationException extends RuntimeException {
  private final int status = HttpStatus.UNPROCESSABLE_ENTITY.value();
  private final String field;

  public BusinessValidationException(String message, String field) {
    super(message);
    this.field = field;
  }
}