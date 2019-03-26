package com.hektorks.user.getuserbyid;

import com.hektorks.user.common.CommandBean;
import com.hektorks.user.common.User;

public interface GetUserByIdCommandBean extends CommandBean<User, Integer> {
  User execute(Integer userId);
}
