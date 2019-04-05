/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.dto.mappers;

import com.hektorks.user.dto.GetUserByIdDto;
import com.hektorks.user.exceptions.MapperException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

@Slf4j
public class GetUserDtoMapper {
  private static final String ID = "id";
  private static final String FIRST_NAME = "firstName";
  private static final String LAST_NAME = "lastName";
  private static final String USERNAME = "username";
  private static final String EMAIL = "email";
  private static final String PHONE_NUMBER = "phoneNumber";
  private static final String COUNTRY_CODE = "countryCode";

  public static GetUserByIdDto fromJson(String jsonBody) {
    try {
      JSONObject jsonObject = new JSONObject(jsonBody);
      return new GetUserByIdDto(
          jsonObject.getInt(ID),
          jsonObject.getString(FIRST_NAME),
          jsonObject.getString(LAST_NAME),
          jsonObject.getString(USERNAME),
          jsonObject.getString(EMAIL),
          jsonObject.getString(PHONE_NUMBER),
          jsonObject.getString(COUNTRY_CODE)
      );
    } catch (JSONException exception) {
      log.warn("Mapping from json body [{}] failed.", jsonBody, exception);
      throw new MapperException(jsonBody, exception);
    }
  }
}