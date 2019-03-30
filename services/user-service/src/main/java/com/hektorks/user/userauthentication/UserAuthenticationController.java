/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

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
@RequestMapping("/v1")
@AllArgsConstructor
class UserAuthenticationController {

  private final UserAuthenticationCommandBean userAuthenticationCommandBean;

  @PostMapping("/user/authentication")
  public ResponseEntity createUser(
      @Valid @RequestBody UserAuthenticationRequest userAuthenticationRequest,
      Errors errors
  ) {
    if (errors.hasErrors()) {
      throw new RequestValidationException(RequestValidationErrors.fromContextErrors(errors));
    }
    Integer userId = userAuthenticationCommandBean.execute(userAuthenticationRequest);
    return ResponseEntity.ok(new UserAuthenticationResponse(userId));
  }
}