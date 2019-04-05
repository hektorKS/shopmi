/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.usernameavailability;

import com.hektorks.exceptionhandling.RequestValidationErrors;
import com.hektorks.exceptionhandling.RequestValidationException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
class UsernameAvailabilityController {

  private final UsernameAvailabilityCommandBean usernameAvailabilityCommandBean;

  @PostMapping("/username/availability")
  public ResponseEntity checkUsernameAvailability(
      @Valid @RequestBody UsernameAvailabilityRequest usernameAvailabilityRequest,
      Errors errors
  ) {
    if (errors.hasErrors()) {
      throw new RequestValidationException(RequestValidationErrors.fromContextErrors(errors));
    }
    UsernameAvailabilityResponse signInResponse = UsernameAvailabilityResponse.create(
        usernameAvailabilityCommandBean.execute(usernameAvailabilityRequest)
    );
    return ResponseEntity.ok(signInResponse);
  }
}