/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
class SignInResponse {
  private String token;
}
