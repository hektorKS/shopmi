package com.hektorks.user.updateuser;


import com.hektorks.user.common.validation.BusinessValidatorBean;

interface UpdateUserRequestValidatorBean extends BusinessValidatorBean<UpdateUserRequest> {
  @Override
  void validate(UpdateUserRequest updateUserRequest);
}