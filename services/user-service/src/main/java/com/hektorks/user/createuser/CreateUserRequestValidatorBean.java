/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.BusinessValidatorBean;

interface CreateUserRequestValidatorBean extends BusinessValidatorBean<CreateUserRequest> {
  @Override
  void validate(CreateUserRequest createUserRequest);
}