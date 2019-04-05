/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup;

import com.hektorks.dashboard.common.CommandBean;
import com.hektorks.dashboard.common.model.UserToken;

interface SignUpCommandBean extends CommandBean<UserToken, SignUpRequest> {
  @Override
  UserToken execute(SignUpRequest createUserRequest);
}