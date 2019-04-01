/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup;

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
@RequestMapping("/api/v1/user")
@AllArgsConstructor
class SignUpController {

  private final SignUpCommandBean signUpCommandBean;

  @PostMapping("/sign-up")
  public ResponseEntity createUser(@Valid @RequestBody SignUpRequest signUpRequest, Errors errors) {
    if (errors.hasErrors()) {
      throw new RequestValidationException(RequestValidationErrors.fromContextErrors(errors));
    }
    SignUpResponse signInResponse = SignUpResponse.create(signUpCommandBean.execute(signUpRequest));
    return ResponseEntity.ok(signInResponse);
  }
}
