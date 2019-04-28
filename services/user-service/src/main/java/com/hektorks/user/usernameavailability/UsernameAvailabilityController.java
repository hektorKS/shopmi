/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.usernameavailability;

import com.hektorks.user.common.VerifiableController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
class UsernameAvailabilityController extends VerifiableController {

  private final UsernameAvailabilityCommandBean usernameAvailabilityCommandBean;

  @PostMapping("/user/username/availability")
  ResponseEntity checkUsernameAvailability(
      @Valid @RequestBody UsernameAvailabilityRequest usernameAvailabilityRequest,
      Errors errors
  ) {
    handleErrors(errors);
    String username = usernameAvailabilityRequest.getUsername();
    boolean isAvailable = usernameAvailabilityCommandBean.execute(username);
    return ResponseEntity.ok(UsernameAvailabilityResponse.create(username, isAvailable));
  }
}