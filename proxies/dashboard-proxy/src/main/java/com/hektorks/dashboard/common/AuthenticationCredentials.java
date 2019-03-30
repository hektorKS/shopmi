/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;

@Data
@ToString
@AllArgsConstructor
public class AuthenticationCredentials {
  private String username;
  @Exclude
  private String password;
}