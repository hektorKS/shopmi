/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.userauthentication;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.user.common.model.User;
import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.common.validation.UsernameBusinessValidatorBean;
import com.hektorks.user.userauthentication.exceptions.UserAuthenticationCommandException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class UserAuthenticationCommandBeanImpl implements UserAuthenticationCommandBean {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;
  private final UsernameBusinessValidatorBean usernameBusinessValidatorBean;

  @Override
  public Integer execute(UserAuthenticationRequest userAuthenticationRequest) {
    try {
      String username = userAuthenticationRequest.getUsername();
      usernameBusinessValidatorBean.validate(username);

      User currentUser = usersRepository.getUserByUsername(username);
      if (currentUser == null) {
        log.info("User with username {} not found.", username);
        throw new ResourceNotFoundException();
      }

      String currentPassword = passwordEncryptionBean.decrypt(currentUser.getEncryptedPassword());
      if (!currentPassword.equals(userAuthenticationRequest.getPassword())) {
        throw new BusinessValidationException("Invalid password.", "password");
      }
      return currentUser.getId();
    } catch (ResourceNotFoundException exception) {
      throw exception;
    } catch (BusinessValidationException exception) {
      log.info("Business validation failed for change user password request [{}].", userAuthenticationRequest);
      throw exception;
    } catch (Exception exception) {
      log.warn("Changing user password failed", exception);
      throw new UserAuthenticationCommandException(exception);
    }
  }
}