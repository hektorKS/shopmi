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
public class RestClientProxyException extends RuntimeException {
  private final HttpStatus status;

  public RestClientProxyException(HttpStatus status, String message) {
    super(message);
    this.status = status;
  }
}
