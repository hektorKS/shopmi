/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup;

import com.hektorks.dashboard.common.VerifiableController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
class SignUpController extends VerifiableController {

  private final SignUpCommandBean signUpCommandBean;

  private static final boolean DEFAULT_SIGN_IN = false;

  @PostMapping("/user/sign-up")
  public ResponseEntity createUser(
      @Valid @RequestBody SignUpRequest signUpRequest,
      @RequestParam("signIn") Optional<Boolean> signIn,
      Errors errors
  ) {
    handleErrors(errors);
    SignUpResponse signInResponse = SignUpResponse.create(
        signUpCommandBean.execute(signUpRequest, signIn.orElse(DEFAULT_SIGN_IN))
    );
    return ResponseEntity.ok(signInResponse);
  }
}