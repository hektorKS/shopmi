/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.updateuser;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.user.common.model.User;
import com.hektorks.user.common.model.UserData;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.createuser.exceptions.EmailAlreadyUsedException;
import com.hektorks.user.createuser.exceptions.UsernameExistsException;
import com.hektorks.user.getuserbyid.GetUserByIdCommandBean;
import com.hektorks.user.updateuser.exceptions.UpdateUserCommandException;
import com.hektorks.user.userexists.UserExistsByEmailCommandBean;
import com.hektorks.user.userexists.UserExistsByIdCommandBean;
import com.hektorks.user.userexists.UserExistsByUsernameCommandBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UpdateUserByIdCommandBeanImpl implements UpdateUserByIdCommandBean {

  private final UserExistsByUsernameCommandBean userExistsByUsernameCommandBean;
  private final UserExistsByEmailCommandBean userExistsByEmailCommandBean;
  private final GetUserByIdCommandBean getUserByIdCommandBean;
  private final UpdateUserRequestValidatorBean updateUserRequestValidatorBean;
  private final UserExistsByIdCommandBean userExistsByIdCommandBean;
  private final UsersRepository usersRepository;

  @Override
  public Void execute(UpdateUserRequest updateUserRequest, Integer userId) {
    try {
      if (!updateUserRequest.isNotEmpty()) {
        return null;
      }
      updateUserRequestValidatorBean.validate(updateUserRequest);

      if (!userExistsByIdCommandBean.execute(userId)) {
        log.info("User with id [{}] not found.", userId);
        throw new ResourceNotFoundException();
      }

      User currentUser = getUserByIdCommandBean.execute(userId);
      String username = updateUserRequest.getUsername();
      String currentUsername = currentUser.getUsername();
      boolean usernameChanged = username != null && !currentUsername.equals(username);
      if (usernameChanged && userExistsByUsernameCommandBean.execute(username)) {
        log.info("Username [{}] is already used.", username);
        throw new UsernameExistsException(username);
      }

      String email = updateUserRequest.getEmail();
      String currentEmail = currentUser.getEmail();
      boolean emailChanged = email != null && !currentEmail.equals(email);
      if (emailChanged && userExistsByEmailCommandBean.execute(email)) {
        log.info("Email {} is already used.", email);
        throw new EmailAlreadyUsedException(email);
      }

      usersRepository.updateUserData(new UserData(
          userId,
          updateUserRequest.getFirstName(),
          updateUserRequest.getLastName(),
          updateUserRequest.getUsername(),
          updateUserRequest.getEmail(),
          updateUserRequest.getPhoneNumber(),
          updateUserRequest.getCountryCode()
      ));
      log.info("User successfully updated with new data [{}].", updateUserRequest);
    } catch (BusinessValidationException exception) {
      log.info("Business validation failed for update user request [{}].", updateUserRequest);
      throw exception;
    } catch (ResourceNotFoundException exception) {
      throw exception;
    } catch (Exception exception) {
      log.warn("Updating user failed", exception);
      throw new UpdateUserCommandException(exception);
    }
    return null;
  }
}