/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
class UserAuthenticationFailedExceptionMapper extends RuntimeException {
  private static final String MESSAGE = "message";
  private static final String REASON = "reason";

  static Map<String, Object> toMap(UserAuthenticationFailedException exception) {
    Map<String, Object> result = new HashMap<>();
    result.put(MESSAGE, exception.getMessage());
    result.put(REASON, exception.getReason());
    return result;
  }
}