/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.dto.mappers;

import com.hektorks.user.dto.UsernameAvailabilityDto;
import com.hektorks.user.exceptions.MapperException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Slf4j
public class UsernameAvailabilityDtoMapper {
  private static final String USERNAME = "username";
  private static final String IS_AVAILABLE = "isAvailable";

  public static UsernameAvailabilityDto fromJson(String jsonBody) {
    try {
      JSONObject jsonObject = new JSONObject(jsonBody);
      return new UsernameAvailabilityDto(
          jsonObject.getString(USERNAME),
          jsonObject.getBoolean(IS_AVAILABLE)
      );
    } catch (JSONException exception) {
      log.warn("Mapping from json body [{}] failed.", jsonBody, exception);
      throw new MapperException(jsonBody, exception);
    }
  }
}