/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.dashboard.common.CommandBean;

interface GetUserProfileCommandBean extends CommandBean<String, String> {
  @Override
  String execute(String token);
}