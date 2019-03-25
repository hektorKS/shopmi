package com.hektorks.user.updateuser;

import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.updateuser.exceptions.UpdateUserCommandException;
import com.hektorks.user.userexists.UserExistsCommandBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UpdateUserByIdCommandBeanImpl implements UpdateUserByIdCommandBean {

  private final UpdateUserRequestValidatorBean updateUserRequestValidatorBean;
  private final UserExistsCommandBean userExistsCommandBean;
  private final UsersRepository usersRepository;

  @Override
  public Void execute(UpdateUserRequest updateUserRequest) {
    updateUserRequestValidatorBean.validate(updateUserRequest);
    try {
      if (!userExistsCommandBean.execute(updateUserRequest.getId())) {
        throw new ResourceNotFoundException();
      }

      if (!updateUserRequest.isNotEmpty()) {
        return null;
      }

//      TODO USER REPOSITORY HERE
    } catch(ResourceNotFoundException exception){
      log.info("");//TODO
    } catch (Exception exception) {
      throw new UpdateUserCommandException(exception);
    }


    return null;
  }
}
