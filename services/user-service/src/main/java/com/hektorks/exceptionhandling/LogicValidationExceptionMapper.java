package com.hektorks.exceptionhandling;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LogicValidationExceptionMapper {
  private static final String STATUS = "status";
  private static final String FIELD = "field";
  private static final String MESSAGE = "message";

  public static JSONObject toJson(LogicValidationException logicValidationException) {
    Map<String, Object> result = new HashMap<>();
    result.put(STATUS, logicValidationException.getStatus());
    result.put(FIELD, logicValidationException.getField());
    result.put(MESSAGE, logicValidationException.getMessage());
    return new JSONObject(result);
  }
}
