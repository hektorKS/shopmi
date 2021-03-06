/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.dto.mappers;

import com.hektorks.user.dto.CreateUserDto;
import com.hektorks.user.exceptions.MapperException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Slf4j
public class CreateUserDtoMapper {
  private static final String USER_ID = "userId";

  public static CreateUserDto fromJson(String jsonBody) {
    try {
      JSONObject jsonObject = new JSONObject(jsonBody);
      return new CreateUserDto(
          jsonObject.getInt(USER_ID)
      );
    } catch (JSONException exception) {
      log.warn("Mapping from json body [{}] failed.", jsonBody, exception);
      throw new MapperException(jsonBody, exception);
    }
  }
}