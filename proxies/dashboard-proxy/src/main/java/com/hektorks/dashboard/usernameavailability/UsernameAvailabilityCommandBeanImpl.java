/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import com.hektorks.dashboard.common.model.UsernameAvailability;
import com.hektorks.dashboard.usernameavailability.exceptions.UsernameAvailabilityCommandException;
import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.RequestValidationException;
import com.hektorks.user.UserService;
import com.hektorks.user.dto.UsernameAvailabilityDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UsernameAvailabilityCommandBeanImpl implements UsernameAvailabilityCommandBean {

  private final UserService userService;

  @Override
  public UsernameAvailability execute(UsernameAvailabilityRequest usernameAvailabilityRequest) {
    try {
      UsernameAvailabilityDto usernameAvailabilityDto = userService.checkUsernameAvailability(usernameAvailabilityRequest);
      return new UsernameAvailability(
          usernameAvailabilityDto.getUsername(),
          usernameAvailabilityDto.isAvailable()
      );
    } catch (BusinessValidationException | RequestValidationException exception) {
      throw exception;
    } catch (Exception exception) {
      log.warn("Checking username availability failed.", exception);
      throw new UsernameAvailabilityCommandException(usernameAvailabilityRequest.getUsername(), exception);
    }
  }
}
