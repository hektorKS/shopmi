/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.BusinessValidationExceptionMapper;
import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.RequestValidationErrors;
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
class CreateUserController {

  private final CreateUserCommandBean createUserCommandBean;

  @PostMapping("/user")
  public ResponseEntity createUser(@Valid @RequestBody CreateUserRequest createUserRequest, Errors errors) {
    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(RequestValidationErrors.fromContextErrors(errors));
    }
    try {
      CreateUserResponse createUserResponse = new CreateUserResponse(createUserCommandBean.execute(createUserRequest));
      return ResponseEntity.ok(createUserResponse);
    } catch (BusinessValidationException exception) {
      return ResponseEntity.unprocessableEntity().body(BusinessValidationExceptionMapper.toMap(exception));
    } catch (CommandException exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
  }
}
