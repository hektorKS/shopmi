/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.dashboard.common.AuthenticationCredentials;
import com.hektorks.user.dto.GetUserByIdResponse;
import com.hektorks.user.dto.UserAuthenticationResponse;


public interface UserService {
  UserAuthenticationResponse userAuthentication(AuthenticationCredentials signInRequest);

  GetUserByIdResponse getUserById(Integer userId);
}