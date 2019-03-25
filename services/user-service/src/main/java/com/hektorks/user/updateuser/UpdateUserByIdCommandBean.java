package com.hektorks.user.updateuser;

import com.hektorks.user.common.CommandBean;

interface UpdateUserByIdCommandBean extends CommandBean<Void, UpdateUserRequest> {
  Void execute(UpdateUserRequest data);
}
