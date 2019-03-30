/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
@EqualsAndHashCode(callSuper = true)
class JWTAuthenticationToken extends UsernamePasswordAuthenticationToken {
  private String token;

  JWTAuthenticationToken(String token) {
    super(null, null);
    this.token = token;
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }
}
