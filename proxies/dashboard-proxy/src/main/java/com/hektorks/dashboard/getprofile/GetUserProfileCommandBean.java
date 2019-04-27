/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.dashboard.common.model.UserProfile;

interface GetUserProfileCommandBean {
  UserProfile execute(Integer userId);
}