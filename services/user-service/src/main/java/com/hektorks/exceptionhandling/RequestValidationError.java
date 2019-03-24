package com.hektorks.exceptionhandling;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PACKAGE)
class RequestValidationError {
  private final String field;
  private final String message;
}
