/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security;

import com.hektorks.security.JWTAuthenticationToken;
import com.hektorks.security.JWTUserDetails;
import com.hektorks.security.tokenservice.TokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
class JWTAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
  private final TokenService tokenService;

  @Override
  protected void additionalAuthenticationChecks(
      UserDetails userDetails,
      UsernamePasswordAuthenticationToken authentication
  ) throws AuthenticationException {
  }

  @Override
  protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
      throws AuthenticationException {
    JWTAuthenticationToken jwtAuthenticationToken = (JWTAuthenticationToken) authentication;
    try {
      String token = jwtAuthenticationToken.getToken();
      Integer userId = tokenService.getUserId(token);
      return new JWTUserDetails(userId);
    } catch (SecurityException exception) {
      throw new AuthenticationCredentialsNotFoundException(exception.getMessage());
    }
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return (JWTAuthenticationToken.class.isAssignableFrom(authentication));
  }
}
