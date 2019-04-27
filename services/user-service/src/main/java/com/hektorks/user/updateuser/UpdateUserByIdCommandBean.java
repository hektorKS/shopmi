/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

interface UpdateUserByIdCommandBean {
  Void execute(UpdateUserRequest data, Integer userId);
}