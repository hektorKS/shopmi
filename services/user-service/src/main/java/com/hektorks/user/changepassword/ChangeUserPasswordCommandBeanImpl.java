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
import com.hektorks.user.common.passwordencryption.EncryptedPassword;
import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
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
      User user = getUserByIdCommandBean.execute(changeUserPasswordRequest.getUserId());
      if (user == null) {
        log.info("User with id [{}] not found.", changeUserPasswordRequest.getUserId());
        throw new ResourceNotFoundException();
      }
      passwordBusinessValidatorBean.validate(new PasswordValidationEntity(
          changeUserPasswordRequest.getNewPassword(),
          user.getFirstName(),
          user.getLastName(),
          user.getUsername(),
          user.getEmail(),
          user.getPhoneNumber()
      ));

      String realOldPassword = passwordEncryptionBean.decrypt(user.getEncryptedPassword());
      if (!realOldPassword.equals(changeUserPasswordRequest.getOldPassword())) {
        throw new InvalidOldPasswordException();
      }

      EncryptedPassword newEncryptedPassword = passwordEncryptionBean.encrypt(changeUserPasswordRequest.getNewPassword());
      user.setEncryptedPassword(newEncryptedPassword);
      usersRepository.updateUser(user);
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
