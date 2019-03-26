/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;


import com.hektorks.user.common.validation.BusinessValidatorBean;

interface UpdateUserRequestValidatorBean extends BusinessValidatorBean<UpdateUserRequest> {
  @Override
  void validate(UpdateUserRequest updateUserRequest);
}