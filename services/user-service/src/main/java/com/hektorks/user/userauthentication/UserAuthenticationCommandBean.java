/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import com.hektorks.user.common.CommandBean;

interface UserAuthenticationCommandBean extends CommandBean<Integer, UserAuthenticationRequest> {
  @Override
  Integer execute(UserAuthenticationRequest userAuthenticationRequest);
}