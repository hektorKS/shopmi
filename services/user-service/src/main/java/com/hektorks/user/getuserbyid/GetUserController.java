/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.getuserbyid;

import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.user.common.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class GetUserController {

  private final GetUserByIdCommandBean getUserByIdCommandBean;

  @GetMapping("/user/{userId}")
  ResponseEntity getUser(@PathVariable Integer userId) {
    try {
      User user = getUserByIdCommandBean.execute(userId);
      if (user == null) {
        log.info("User not found for id [{}]", userId);
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(GetUserResponse.create(user));
    } catch (CommandException exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
  }

}
