/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.user.dto.UserAuthenticationRequest;
import com.hektorks.user.dto.UserAuthenticationResponse;


public interface UserService {
  UserAuthenticationResponse userAuthentication(UserAuthenticationRequest signInRequest);
}