package com.hektorks.user.userexists;

import com.hektorks.user.common.CommandBean;

interface UserExistsCommandBean extends CommandBean<Boolean, Integer> {
  Boolean execute(Integer data);
}
