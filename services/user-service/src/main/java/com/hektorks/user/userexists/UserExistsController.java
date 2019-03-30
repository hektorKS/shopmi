/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

import com.hektorks.exceptionhandling.CommandException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class UserExistsController {

  private final UserExistsCommandBean userExistsCommandBean;

  @RequestMapping(value = "/user/{userId}", method = RequestMethod.HEAD)
  ResponseEntity userExists(@PathVariable Integer userId) {
    try {
      if (userExistsCommandBean.execute(userId)) {
        return ResponseEntity.ok().body(null);
      } else {
        return ResponseEntity.notFound().build();
      }
    } catch (CommandException exception) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
  }

}
