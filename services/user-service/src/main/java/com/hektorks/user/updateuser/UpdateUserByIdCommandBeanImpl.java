package com.hektorks.user.updateuser;

import com.hektorks.user.updateuser.exceptions.UpdateUserCommandException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class UpdateUserByIdCommandBeanImpl implements UpdateUserByIdCommandBean {

  private final UpdateUserRequestValidatorBean updateUserRequestValidatorBean;

  @Override
  public Void execute(UpdateUserRequest updateUserRequest) {
    updateUserRequestValidatorBean.validate(updateUserRequest);

    try {
      //TODO to + SQL
    } catch (Exception exception) {
      throw new UpdateUserCommandException(exception);
    }

    if (!updateUserRequest.isNotEmpty()) {
      return null;
    }

    return null;
  }
}
