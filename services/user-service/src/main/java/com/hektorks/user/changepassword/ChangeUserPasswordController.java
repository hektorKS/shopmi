/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.BusinessValidationExceptionMapper;
import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.RequestValidationErrors;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
class ChangeUserPasswordController {

  private final ChangeUserPasswordCommandBean changeUserPasswordCommandBean;

  @PatchMapping("/user/{userId}/password")
  public ResponseEntity changeUserPassword(@PathVariable Integer userId,
                                           @Valid @RequestBody ChangeUserPasswordRequest changeUserPasswordRequest,
                                           Errors errors
  ) {
    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(RequestValidationErrors.fromContextErrors(errors));
    }
    try {
      changeUserPasswordRequest.setUserId(userId);
      changeUserPasswordCommandBean.execute(changeUserPasswordRequest);
      return ResponseEntity.noContent().build();
    } catch (ResourceNotFoundException exception) {
      return ResponseEntity.notFound().build();
    } catch (BusinessValidationException exception) {
      return ResponseEntity.unprocessableEntity().body(BusinessValidationExceptionMapper.toMap(exception));
    } catch (CommandException exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
  }
}
