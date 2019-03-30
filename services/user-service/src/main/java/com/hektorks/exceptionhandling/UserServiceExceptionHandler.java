/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@ControllerAdvice
public class UserServiceExceptionHandler {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = RequestValidationException.class)
  public RequestValidationErrors handleException(RequestValidationException exception) {
    return exception.getErrors();
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(value = ResourceNotFoundException.class)
  public Void handleException() {
    return null;
  }

  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  @ExceptionHandler(value = BusinessValidationException.class)
  public Map<String, Object> handleException(BusinessValidationException exception) {
    return BusinessValidationExceptionMapper.toMap(exception);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = CommandException.class)
  public String handleException(CommandException exception) {
    return exception.getMessage();
  }
}
