/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import lombok.AllArgsConstructor;
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
    updateUserRequest.setUserId(userId);
    updateUserByIdCommandBean.execute(updateUserRequest);
    return ResponseEntity.noContent().build();
  }
}