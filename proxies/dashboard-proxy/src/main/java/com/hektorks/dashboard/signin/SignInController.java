/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.RequestValidationErrors;
import com.hektorks.exceptionhandling.RequestValidationException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.exceptionhandling.UserAuthenticationFailedException;
import com.hektorks.exceptionhandling.UserAuthenticationFailedExceptionMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
class SignInController {

  private final SignInCommandBean signInCommandBean;

  @PostMapping("/sign-in")
  public ResponseEntity createUser(@Valid @RequestBody SignInRequest signInRequest, Errors errors) {
    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(RequestValidationErrors.fromContextErrors(errors));
    }
    try {
      SignInResponse signInResponse = new SignInResponse(signInCommandBean.execute(signInRequest));
      return ResponseEntity.ok(signInResponse);
    } catch (UserAuthenticationFailedException exception) {
      return ResponseEntity
          .status(HttpStatus.UNAUTHORIZED)
          .body(UserAuthenticationFailedExceptionMapper.toMap(exception));
    } catch (RequestValidationException exception) {
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body(exception.getErrors());
    } catch (ResourceNotFoundException exception) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .build();
    } catch (CommandException exception) {
      return ResponseEntity.
          status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(exception.getMessage());
    }
  }
}
