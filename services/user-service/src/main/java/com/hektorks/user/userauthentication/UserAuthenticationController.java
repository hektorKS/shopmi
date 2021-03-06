/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import com.hektorks.user.common.VerifiableController;
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
class UserAuthenticationController extends VerifiableController {

  private final UserAuthenticationCommandBean userAuthenticationCommandBean;

  @PostMapping("/user/authentication")
  public ResponseEntity createUser(
      @Valid @RequestBody UserAuthenticationRequest userAuthenticationRequest,
      Errors errors
  ) {
    handleErrors(errors);
    Integer userId = userAuthenticationCommandBean.execute(userAuthenticationRequest);
    return ResponseEntity.ok(UserAuthenticationResponse.create(userId));
  }
}