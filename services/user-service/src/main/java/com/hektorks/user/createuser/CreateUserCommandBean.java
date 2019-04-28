/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

interface CreateUserCommandBean {
  Integer execute(CreateUserRequest createUserRequest);
}