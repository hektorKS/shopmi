/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
class UserAuthenticationResponse {
  private final Integer userId;
}
