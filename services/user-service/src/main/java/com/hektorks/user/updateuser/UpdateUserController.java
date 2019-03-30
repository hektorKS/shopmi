/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.BusinessValidationExceptionMapper;
import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class UpdateUserController {

  private final UpdateUserByIdCommandBean updateUserByIdCommandBean;

  @PatchMapping("/user/{userId}")
  ResponseEntity updateUser(@PathVariable Integer userId, @RequestBody UpdateUserRequest updateUserRequest) {
    try {
      updateUserRequest.setUserId(userId);
      updateUserByIdCommandBean.execute(updateUserRequest);
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
