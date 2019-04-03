/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.dashboard.common.AuthenticationCredentials;
import com.hektorks.dashboard.signup.SignUpRequest;
import com.hektorks.user.dto.CreateUserResponse;
import com.hektorks.user.dto.GetUserByIdResponse;
import com.hektorks.user.dto.UserAuthenticationResponse;


public interface UserService {

  UserAuthenticationResponse userAuthentication(AuthenticationCredentials signInRequest);

  CreateUserResponse createUser(SignUpRequest signUpRequest);

  GetUserByIdResponse getUserById(Integer userId);
}