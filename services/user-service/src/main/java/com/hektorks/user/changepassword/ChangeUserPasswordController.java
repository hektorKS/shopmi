/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import com.hektorks.user.common.VerifiableController;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class ChangeUserPasswordController extends VerifiableController {

  private final ChangeUserPasswordCommandBean changeUserPasswordCommandBean;

  @PatchMapping("/user/{userId}/password")
  public ResponseEntity changeUserPassword(
      @PathVariable Integer userId,
      @Valid @RequestBody ChangeUserPasswordRequest changeUserPasswordRequest,
      Errors errors
  ) {
    handleErrors(errors);
    changeUserPasswordCommandBean.execute(changeUserPasswordRequest, userId);
    return ResponseEntity.noContent().build();
  }
}