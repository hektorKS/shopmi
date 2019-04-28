/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

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
class CreateUserController extends VerifiableController {

  private final CreateUserCommandBean createUserCommandBean;

  @PostMapping("/user")
  public ResponseEntity createUser(@Valid @RequestBody CreateUserRequest createUserRequest, Errors errors) {
    handleErrors(errors);
    CreateUserResponse createUserResponse = CreateUserResponse.create(createUserCommandBean.execute(createUserRequest));
    return ResponseEntity.ok(createUserResponse);
  }
}