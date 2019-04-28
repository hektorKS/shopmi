/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.signin;

interface SignInCommandBean {
  String execute(SignInRequest createUserRequest);
}