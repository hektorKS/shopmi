/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestValidationErrors {
  private final int status;
  private final List<RequestValidationError> errors;

  public static RequestValidationErrors fromContextErrors(Errors errors) {
    return new RequestValidationErrors(
        HttpStatus.BAD_REQUEST.value(),
        errors
            .getFieldErrors()
            .stream()
            .map(fieldError -> new RequestValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList())
    );
  }
}
