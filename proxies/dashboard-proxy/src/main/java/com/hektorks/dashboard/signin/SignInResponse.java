/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;


@Data
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class SignInResponse {
  @Exclude
  private final String token;

  static SignInResponse create(String token) {
    return new SignInResponse(token);
  }
}
