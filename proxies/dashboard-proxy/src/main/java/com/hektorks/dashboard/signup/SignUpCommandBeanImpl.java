/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup;

import com.hektorks.dashboard.common.model.UserToken;
import com.hektorks.dashboard.signup.exceptions.SignUpCommandException;
import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.RequestValidationException;
import com.hektorks.security.tokenservice.TokenService;
import com.hektorks.user.UserService;
import com.hektorks.user.dto.CreateUserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class SignUpCommandBeanImpl implements SignUpCommandBean {

  private final TokenService tokenService;
  private final UserService userService;

  @Override
  public UserToken execute(SignUpRequest signUpRequest) {
    try {
      CreateUserDto response = userService.createUser(signUpRequest);
      return new UserToken(response.getUserId(), tokenService.createToken(response.getUserId()));
    } catch (BusinessValidationException | RequestValidationException exception) {
      throw exception;
    } catch (Exception exception) {
      log.warn("User sign up failed", exception);
      throw new SignUpCommandException(exception);
    }
  }
}