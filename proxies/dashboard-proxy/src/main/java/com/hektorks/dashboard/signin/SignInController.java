/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import com.hektorks.dashboard.common.VerifiableController;
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
class SignInController extends VerifiableController {

  private final SignInCommandBean signInCommandBean;

  @PostMapping("/user/sign-in")
  public ResponseEntity createUser(@Valid @RequestBody SignInRequest signInRequest, Errors errors) {
    handleErrors(errors);
    SignInResponse signInResponse = SignInResponse.create(signInCommandBean.execute(signInRequest));
    return ResponseEntity.ok(signInResponse);
  }
}
