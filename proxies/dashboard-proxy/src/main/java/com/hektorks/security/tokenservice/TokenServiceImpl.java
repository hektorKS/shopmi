/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.security.tokenservice;

import static java.util.concurrent.TimeUnit.SECONDS;

import com.hektorks.consul.config.SecurityConfig;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
class TokenServiceImpl implements TokenService {

  private final SecurityConfig securityConfig;

  private static final String BEARER = "Bearer ";
  private static final String EMPTY = "";
  private static final String AUTHORIZATION_HEADER = "Authorization";
  private static final String USER_ID = "userId";

  @Override
  public String refreshToken(String token) {
    return createToken(getUserId(token));
  }

  @Override
  public String createToken(Integer userId) {
    return Jwts.builder()
        .setExpiration(newExpirationTime())
        .claim(USER_ID, userId)
        .signWith(SignatureAlgorithm.HS256, securityConfig.getJwtSecret())
        .compact();
  }

  @Override
  public String getToken(HttpServletRequest httpServletRequest) {
    String authorizationHeader = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
    return Optional.ofNullable(authorizationHeader)
        .map(String::trim)
        .filter(header -> header.startsWith(BEARER))
        .map(header -> header.replace(BEARER, EMPTY))
        .orElseThrow(() -> new SecurityException("Security token not found"));
  }

  @Override
  public Integer getUserId(String token) {
    try {
      return Jwts.parser()
          .setSigningKey(securityConfig.getJwtSecret())
          .parseClaimsJws(token)
          .getBody()
          .get(USER_ID, Integer.class);
    } catch (JwtException exception) {
      throw new SecurityException("Security token is invalid");
    }
  }

  private Date newExpirationTime() {
    return new Date(Instant.now().toEpochMilli() + SECONDS.toMillis(securityConfig.getJwtExpirationSeconds()));
  }

}
