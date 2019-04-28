/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class UserExistsController {

  private final UserExistsByIdCommandBean userExistsByIdCommandBean;

  @RequestMapping(value = "/user/{userId}", method = RequestMethod.HEAD)
  ResponseEntity userExists(@PathVariable Integer userId) {
    if (userExistsByIdCommandBean.execute(userId)) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}