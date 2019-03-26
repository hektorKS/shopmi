/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class CreateUserResponse {
  private final Integer userId;
}
