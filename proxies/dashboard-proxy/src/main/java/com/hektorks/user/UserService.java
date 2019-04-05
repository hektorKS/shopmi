/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user;

import com.hektorks.dashboard.signin.SignInRequest;
import com.hektorks.dashboard.signup.SignUpRequest;
import com.hektorks.dashboard.usernameavailability.UsernameAvailabilityRequest;
import com.hektorks.user.dto.CreateUserDto;
import com.hektorks.user.dto.GetUserByIdDto;
import com.hektorks.user.dto.UserAuthenticationDto;
import com.hektorks.user.dto.UsernameAvailabilityDto;


public interface UserService {

  UserAuthenticationDto userAuthentication(SignInRequest signInRequest);

  UsernameAvailabilityDto checkUsernameAvailability(UsernameAvailabilityRequest username);

  CreateUserDto createUser(SignUpRequest signUpRequest);

  GetUserByIdDto getUserById(Integer userId);
}