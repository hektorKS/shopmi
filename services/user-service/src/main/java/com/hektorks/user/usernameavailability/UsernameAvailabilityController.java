/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.RequestValidationErrors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class UsernameAvailabilityController {

  private final UsernameAvailabilityCommandBean usernameAvailabilityCommandBean;

  @PostMapping("/user/username/availability")
  ResponseEntity checkUsernameAvailability(@Valid @RequestBody UsernameAvailabilityRequest usernameAvailabilityRequest,
                                           Errors errors
  ) {
    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(RequestValidationErrors.fromContextErrors(errors));
    }
    try {
      String username = usernameAvailabilityRequest.getUsername();
      boolean isUsernameTaken = usernameAvailabilityCommandBean.execute(username);
      return ResponseEntity.ok(new UsernameAvailabilityResponse(username, isUsernameTaken));
    } catch (CommandException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}