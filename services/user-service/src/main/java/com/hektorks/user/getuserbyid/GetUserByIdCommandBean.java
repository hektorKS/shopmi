/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.getuserbyid;

import com.hektorks.user.common.CommandBean;
import com.hektorks.user.common.User;

public interface GetUserByIdCommandBean extends CommandBean<User, Integer> {
  @Override
  User execute(Integer userId);
}