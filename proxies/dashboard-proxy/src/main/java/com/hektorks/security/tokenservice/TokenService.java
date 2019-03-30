/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security.tokenservice;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

  String refreshToken(String token);

  String createToken(Integer userId);

  String getToken(HttpServletRequest httpServletRequest);

  Integer getUserId(String token);

}