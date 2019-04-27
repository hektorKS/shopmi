/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

interface ChangeUserPasswordCommandBean {
  Void execute(ChangeUserPasswordRequest data, Integer userId);
}