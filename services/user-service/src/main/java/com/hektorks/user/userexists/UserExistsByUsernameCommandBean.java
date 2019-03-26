/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

import com.hektorks.user.common.CommandBean;

public interface UserExistsByUsernameCommandBean extends CommandBean<Boolean, String> {
  @Override
  Boolean execute(String data);
}
