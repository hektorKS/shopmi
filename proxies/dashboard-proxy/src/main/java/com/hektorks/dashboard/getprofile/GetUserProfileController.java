/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import lombok.AllArgsConstructor;
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

  @GetMapping("/user/profile")
  public ResponseEntity getUserProfile(@RequestAttribute Integer userId) {
    GetUserProfileResponse getUserProfileResponse = GetUserProfileResponse.create(getUserProfileCommandBean.execute(userId));
    return ResponseEntity.ok(getUserProfileResponse);
  }
}