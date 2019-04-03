/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import com.hektorks.user.common.CommandBean;

interface ChangeUserPasswordCommandBean extends CommandBean<Void, ChangeUserPasswordRequest> {
  @Override
  Void execute(ChangeUserPasswordRequest data);
}