package com.hektorks.exceptionhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LogicValidationException extends RuntimeException {
  private final int status;
  private final String field;

  public LogicValidationException(String message, int status, String field) {
    super(message);
    this.status = status;
    this.field = field;
  }
}