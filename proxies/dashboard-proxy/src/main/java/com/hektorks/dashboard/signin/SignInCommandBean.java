/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

import com.hektorks.dashboard.common.CommandBean;

interface SignInCommandBean extends CommandBean<String, SignInRequest> {
  @Override
  String execute(SignInRequest createUserRequest);
}