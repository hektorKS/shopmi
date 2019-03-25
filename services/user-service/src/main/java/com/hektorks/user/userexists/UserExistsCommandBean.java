package com.hektorks.user.userexists;

import com.hektorks.user.common.CommandBean;

public interface UserExistsCommandBean extends CommandBean<Boolean, Integer> {
  Boolean execute(Integer data);
}
