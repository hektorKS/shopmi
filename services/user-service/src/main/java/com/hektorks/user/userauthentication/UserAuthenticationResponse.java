/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class UserAuthenticationResponse {
  private final Integer userId;

  static UserAuthenticationResponse create(Integer userId) {
    return new UserAuthenticationResponse(userId);
  }
}