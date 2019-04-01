/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class JWTAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

  private static final String USER_ID = "userId";

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication
  ) {
    JWTUserDetails jwtUserDetails = (JWTUserDetails) authentication.getPrincipal();
    request.setAttribute(USER_ID, jwtUserDetails.getUserId());
  }
}