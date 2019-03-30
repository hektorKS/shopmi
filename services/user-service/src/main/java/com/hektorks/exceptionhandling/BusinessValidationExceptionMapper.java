/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;


import java.util.HashMap;
import java.util.Map;

class BusinessValidationExceptionMapper {
  private static final String STATUS = "status";
  private static final String FIELD = "field";
  private static final String MESSAGE = "message";

  static Map<String, Object> toMap(BusinessValidationException businessValidationException) {
    Map<String, Object> result = new HashMap<>();
    result.put(STATUS, businessValidationException.getStatus());
    result.put(FIELD, businessValidationException.getField());
    result.put(MESSAGE, businessValidationException.getMessage());
    return result;
  }
}
