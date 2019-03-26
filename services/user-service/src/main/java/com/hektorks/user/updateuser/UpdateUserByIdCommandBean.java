/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import com.hektorks.user.common.CommandBean;

interface UpdateUserByIdCommandBean extends CommandBean<Void, UpdateUserRequest> {
  @Override
  Void execute(UpdateUserRequest data);
}
