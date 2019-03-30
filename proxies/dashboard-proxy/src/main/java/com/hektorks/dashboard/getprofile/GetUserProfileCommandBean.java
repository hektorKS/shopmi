/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.dashboard.common.CommandBean;
import com.hektorks.dashboard.common.UserProfile;

interface GetUserProfileCommandBean extends CommandBean<UserProfile, Integer> {
  @Override
  UserProfile execute(Integer userId);
}