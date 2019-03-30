/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.BusinessValidationExceptionMapper;
import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.RequestValidationErrors;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
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
      return ResponseEntity.badRequest().body(RequestValidationErrors.fromContextErrors(errors));
    }
    try {
      Integer userId = userAuthenticationCommandBean.execute(userAuthenticationRequest);
      return ResponseEntity.ok(new UserAuthenticationResponse(userId));
    } catch (ResourceNotFoundException exception) {
      return ResponseEntity.notFound().build();
    } catch (BusinessValidationException exception) {
      return ResponseEntity.unprocessableEntity().body(BusinessValidationExceptionMapper.toMap(exception));
    } catch (CommandException exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
  }
}
