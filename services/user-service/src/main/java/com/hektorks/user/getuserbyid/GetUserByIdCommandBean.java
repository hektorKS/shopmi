/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.getuserbyid;

import com.hektorks.user.common.model.User;

public interface GetUserByIdCommandBean {
  User execute(Integer userId);
}