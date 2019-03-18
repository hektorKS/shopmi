package com.hektorks.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class RequestValidationException {
  private final String field;
  private final String message;
}
