/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.dashboard.common.UserProfile;
import com.hektorks.dashboard.getprofile.exceptions.GetUserProfileCommandException;
import com.hektorks.user.UserService;
import com.hektorks.user.dto.GetUserByIdResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class GetUserProfileCommandBeanImpl implements GetUserProfileCommandBean {

  private final UserService userService;

  @Override
  public UserProfile execute(Integer userId) {
    try {
      GetUserByIdResponse getUserByIdResponse = userService.getUserById(userId);
      return new UserProfile(
          getUserByIdResponse.getId(),
          getUserByIdResponse.getFirstName(),
          getUserByIdResponse.getLastName(),
          getUserByIdResponse.getUsername(),
          getUserByIdResponse.getEmail(),
          getUserByIdResponse.getPhoneNumber(),
          getUserByIdResponse.getCountryCode()
      );
    } catch (Exception exception) {
      log.warn("Getting user by id [{}] failed", userId, exception);
      throw new GetUserProfileCommandException(userId,  exception);
    }
  }
}