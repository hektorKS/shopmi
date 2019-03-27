/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.user.changepassword.exceptions.ChangeUserPasswordCommandException;
import com.hektorks.user.changepassword.exceptions.InvalidOldPasswordException;
import com.hektorks.user.common.User;
import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.common.repository.dao.UserPasswordDao;
import com.hektorks.user.common.validation.PasswordBusinessValidatorBean;
import com.hektorks.user.common.validation.PasswordValidationEntity;
import com.hektorks.user.getuserbyid.GetUserByIdCommandBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class ChangeUserPasswordCommandBeanImpl implements ChangeUserPasswordCommandBean {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;
  private final GetUserByIdCommandBean getUserByIdCommandBean;
  private final PasswordBusinessValidatorBean passwordBusinessValidatorBean;

  @Override
  public Void execute(ChangeUserPasswordRequest changeUserPasswordRequest) {
    try {
      User currentUser = getUserByIdCommandBean.execute(changeUserPasswordRequest.getUserId());
      if (currentUser == null) {
        log.info("User with id [{}] not found.", changeUserPasswordRequest.getUserId());
        throw new ResourceNotFoundException();
      }
      passwordBusinessValidatorBean.validate(new PasswordValidationEntity(
          changeUserPasswordRequest.getNewPassword(),
          currentUser.getFirstName(),
          currentUser.getLastName(),
          currentUser.getUsername(),
          currentUser.getEmail(),
          currentUser.getPhoneNumber()
      ));

      String currentPassword = passwordEncryptionBean.decrypt(currentUser.getEncryptedPassword());
      if (!currentPassword.equals(changeUserPasswordRequest.getOldPassword())) {
        throw new InvalidOldPasswordException();
      }

      usersRepository.updateUserPassword(new UserPasswordDao(
          changeUserPasswordRequest.getUserId(),
          passwordEncryptionBean.encrypt(changeUserPasswordRequest.getNewPassword())
      ));
    } catch (ResourceNotFoundException exception) {
      throw exception;
    } catch (BusinessValidationException exception) {
      log.info("Business validation failed for change user password request [{}].", changeUserPasswordRequest);
      throw exception;
    } catch (Exception exception) {
      log.warn("Changing user password failed", exception);
      throw new ChangeUserPasswordCommandException(exception);
    }
    return null;
  }
}
