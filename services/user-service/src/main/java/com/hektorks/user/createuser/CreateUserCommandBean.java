/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import com.hektorks.user.common.CommandBean;

interface CreateUserCommandBean extends CommandBean<Integer, CreateUserRequest> {
  @Override
  Integer execute(CreateUserRequest createUserRequest);
}