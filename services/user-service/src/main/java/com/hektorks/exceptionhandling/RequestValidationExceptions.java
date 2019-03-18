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
public class RequestValidationExceptions {
  private final int status;
  private final List<RequestValidationException> errors;

  public static RequestValidationExceptions fromContextErrors(Errors errors) {
    return new RequestValidationExceptions(
        HttpStatus.BAD_REQUEST.value(),
        errors
            .getFieldErrors()
            .stream()
            .map(fieldError -> new RequestValidationException(fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList())
    );
  }
}
