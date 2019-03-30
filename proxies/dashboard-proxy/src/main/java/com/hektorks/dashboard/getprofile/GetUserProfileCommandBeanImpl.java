/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.security.tokenservice.TokenService;
import com.hektorks.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class GetUserProfileCommandBeanImpl implements GetUserProfileCommandBean {

  private final UserService userService;

  @Override
  public String execute(String token) {
    return "LALALA";
  }
}
