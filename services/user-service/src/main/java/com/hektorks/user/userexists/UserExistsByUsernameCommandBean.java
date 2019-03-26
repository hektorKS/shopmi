package com.hektorks.user.userexists;

import com.hektorks.user.common.CommandBean;

public interface UserExistsByUsernameCommandBean extends CommandBean<Boolean, String> {
  Boolean execute(String data);
}
