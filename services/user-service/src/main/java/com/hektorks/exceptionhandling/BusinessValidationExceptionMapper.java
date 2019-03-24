package com.hektorks.exceptionhandling;


import java.util.HashMap;
import java.util.Map;

public class BusinessValidationExceptionMapper {
  private static final String STATUS = "status";
  private static final String FIELD = "field";
  private static final String MESSAGE = "message";

  public static Map<String, Object> toMap(BusinessValidationException businessValidationException) {
    Map<String, Object> result = new HashMap<>();
    result.put(STATUS, businessValidationException.getStatus());
    result.put(FIELD, businessValidationException.getField());
    result.put(MESSAGE, businessValidationException.getMessage());
    return result;
  }
}
