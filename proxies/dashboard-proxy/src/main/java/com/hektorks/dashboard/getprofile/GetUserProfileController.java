/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.exceptionhandling.CommandException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
class GetUserProfileController {

  private final GetUserProfileCommandBean getUserProfileCommandBean;

  @GetMapping("/profile")
  public ResponseEntity getUserProfile(@RequestAttribute Integer userId) {
    try {
      GetUserProfileResponse signInResponse = new GetUserProfileResponse(userId.toString());
      return ResponseEntity.ok(signInResponse);
    } catch (CommandException exception) {
      return ResponseEntity.
          status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(exception.getMessage());
    }
  }
}
