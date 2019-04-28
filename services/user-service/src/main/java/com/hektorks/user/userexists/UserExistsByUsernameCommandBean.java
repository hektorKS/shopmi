/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userexists;

public interface UserExistsByUsernameCommandBean {
  Boolean execute(String username);
}