/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

import com.hektorks.user.exceptions.MapperException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Slf4j
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestValidationErrors {
  private final int status;
  private final List<RequestValidationError> errors;

  private static final String ERRORS = "errors";
  private static final String FIELD = "field";
  private static final String MESSAGE = "message";

  public static RequestValidationErrors fromContextErrors(Errors errors) {
    return new RequestValidationErrors(
        HttpStatus.BAD_REQUEST.value(),
        errors
            .getFieldErrors()
            .stream()
            .map(fieldError -> new RequestValidationError(fieldError.getField(), fieldError.getDefaultMessage()))
            .collect(Collectors.toList())
    );
  }

  public static RequestValidationErrors fromJson(String jsonString) {
    try {
      JSONObject jsonObject = new JSONObject(jsonString);
      return new RequestValidationErrors(
          HttpStatus.BAD_REQUEST.value(),
          getErrorsFromJson(jsonObject.getJSONArray(ERRORS))
      );
    } catch (Exception exception) {
      log.info("Mapping RequestValidationErrors from json [{}] failed.", jsonString, exception);
      throw new MapperException(jsonString, exception);
    }
  }

  private static List<RequestValidationError> getErrorsFromJson(JSONArray jsonArray) {
    List<RequestValidationError> result = new ArrayList<>();
    for (int index = 0; index < jsonArray.length(); index++) {
      JSONObject jsonObject = jsonArray.getJSONObject(index);
      result.add(new RequestValidationError(jsonObject.getString(FIELD), jsonObject.getString(MESSAGE)));
    }
    return result;
  }
}