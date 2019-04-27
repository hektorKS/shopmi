/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signup;

import com.hektorks.dashboard.common.model.UserToken;

interface SignUpCommandBean {
  UserToken execute(SignUpRequest signUpRequest, boolean signIn);
}