/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import com.hektorks.dashboard.signin.exceptions.SignInCommandException;
import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.RequestValidationException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.exceptionhandling.UserAuthenticationFailedException;
import com.hektorks.security.tokenservice.TokenService;
import com.hektorks.user.UserService;
import com.hektorks.user.dto.UserAuthenticationDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class SignInCommandBeanImpl implements SignInCommandBean {

  private final TokenService tokenService;
  private final UserService userService;

  @Override
  public String execute(SignInRequest signInRequest) {
    try {
      UserAuthenticationDto response = userService.userAuthentication(signInRequest);
      return tokenService.createToken(response.getUserId());
    } catch (BusinessValidationException exception) {
      throw new UserAuthenticationFailedException(signInRequest.getUsername(), exception.getMessage());
    } catch (ResourceNotFoundException | RequestValidationException exception) {
      throw exception;
    } catch (Exception exception) {
      log.warn("User sign-in failed", exception);
      throw new SignInCommandException(exception);
    }
  }
}
