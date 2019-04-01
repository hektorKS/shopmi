/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hektorks.dashboard.common.UserToken;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;


@Data
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class SignUpResponse {
  private final Integer userId;
  @Exclude
  @JsonInclude(Include.NON_NULL)
  private final String token;

  static SignUpResponse create(UserToken userToken) {
    return new SignUpResponse(userToken.getUserId(), userToken.getToken());
  }
}