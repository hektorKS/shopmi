/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

interface UserAuthenticationCommandBean {
  Integer execute(UserAuthenticationRequest userAuthenticationRequest);
}