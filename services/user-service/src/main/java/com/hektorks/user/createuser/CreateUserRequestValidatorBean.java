package com.hektorks.user.createuser;

import com.hektorks.user.common.validation.BusinessValidatorBean;

interface CreateUserRequestValidatorBean extends BusinessValidatorBean<CreateUserRequest> {
  @Override
  void validate(CreateUserRequest createUserRequest);
}
