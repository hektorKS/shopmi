/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class CreateUserResponse {
  private final Integer userId;

  static CreateUserResponse create(Integer userId) {
    return new CreateUserResponse(userId);
  }
}