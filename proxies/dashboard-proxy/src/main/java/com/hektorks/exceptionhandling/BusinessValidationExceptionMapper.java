/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;


import com.hektorks.user.exceptions.MapperException;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Slf4j
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

  public static BusinessValidationException fromJson(String jsonString) {
    try {
      JSONObject jsonObject = new JSONObject(jsonString);
      return new BusinessValidationException(
          jsonObject.getString(MESSAGE),
          jsonObject.getString(FIELD)
      );
    } catch (Exception exception) {
      log.info("Mapping BusinessValidationException from json [{}] failed.", jsonString, exception);
      throw new MapperException(jsonString, exception);
    }
  }
}