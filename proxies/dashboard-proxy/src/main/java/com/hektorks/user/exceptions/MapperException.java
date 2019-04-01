/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.exceptions;

public class MapperException extends RuntimeException {
  public MapperException(String body, Throwable cause) {
    super("Mapping from json body [" + body + "] failed.", cause);
  }
}