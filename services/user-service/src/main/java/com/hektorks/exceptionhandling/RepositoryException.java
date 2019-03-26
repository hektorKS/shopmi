/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

public class RepositoryException extends RuntimeException {
  public RepositoryException(Throwable cause) {
    super(cause);
  }
}
