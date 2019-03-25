package com.hektorks.user.createuser;

import com.hektorks.user.common.CommandBean;

interface CreateUserCommandBean extends CommandBean<Integer, CreateUserRequest> {
  Integer execute(CreateUserRequest createUserRequest);
}