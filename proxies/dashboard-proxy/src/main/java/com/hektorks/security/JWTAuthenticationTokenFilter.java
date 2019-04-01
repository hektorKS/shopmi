/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security;

import com.hektorks.security.tokenservice.TokenService;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class JWTAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
  private final TokenService tokenService;

  JWTAuthenticationTokenFilter(TokenService tokenService) {
    super("/api/**");
    this.tokenService = tokenService;
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws AuthenticationException {
    try {
      String token = tokenService.getToken(request);
      JWTAuthenticationToken jwtAuthenticationToken = new JWTAuthenticationToken(token);
      return getAuthenticationManager().authenticate(jwtAuthenticationToken);
    } catch (SecurityException exception) {
      throw new AuthenticationCredentialsNotFoundException(exception.getMessage());
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication authResult
  ) throws IOException, ServletException {
    super.successfulAuthentication(request, response, chain, authResult);
    chain.doFilter(request, response);
  }
}