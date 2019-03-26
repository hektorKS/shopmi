/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;

class PasswordBusinessValidatorBeanImpl implements PasswordBusinessValidatorBean {

  private static final int PASSWORD_MIN_LENGTH = 8;
  private static final int PASSWORD_MAX_LENGTH = 32;
  private static final String PASSWORD_PATTERN = String
      .format("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{%d,%d}$", PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH);

  @Override
  public void validate(PasswordValidationEntity entity) {
    boolean isValid = isValidPattern(entity.getPassword());

    if (isValid) {
      isValid = isValidWithFields(
          entity.getPassword(),
          entity.getFirstName(),
          entity.getLastName(),
          entity.getUsername(),
          entity.getEmail(),
          entity.getPhoneNumber()
      );
    }

    if (!isValid) {
      throw new BusinessValidationException(
          "Password must be from " + PASSWORD_MIN_LENGTH + " to " + PASSWORD_MAX_LENGTH + " signs long."
              + "It cannot contain white signs."
              + "It cannot contain any of username, firstName, lastName, email."
              + "It must contain at least one lowercase letter, uppercase letter and digit.",
          "password"
      );
    }
  }

  @Override
  public boolean isApplicable(PasswordValidationEntity entity) {
    if (entity != null) {
      return entity.getPassword() != null &&
          entity.getFirstName() != null &&
          entity.getLastName() != null &&
          entity.getEmail() != null &&
          entity.getUsername() != null;
    }
    return false;
  }

  private boolean isValidPattern(String password) {
    return password.matches(PASSWORD_PATTERN);
  }

  private boolean isValidWithFields(
      String password,
      String firstName,
      String lastName,
      String username,
      String email,
      String phoneNumber
  ) {
    String lowercasePassword = password.toLowerCase();
    String lowercaseUsername = username.toLowerCase();
    boolean isValid = isValidWithUsername(lowercasePassword, lowercaseUsername);

    if (isValid) {
      String lowercaseFirstName = firstName.toLowerCase();
      isValid = isValidWithFirstName(lowercasePassword, lowercaseFirstName);
    }

    if (isValid) {
      String lowercaseLastName = lastName.toLowerCase();
      isValid = isValidWithLastName(lowercasePassword, lowercaseLastName);
    }

    if (isValid) {
      String lowercaseEmail = email.toLowerCase();
      isValid = isValidWithEmail(lowercasePassword, lowercaseEmail);
    }

    if (isValid) {
      isValid = isValidWithPhoneNumber(lowercasePassword, phoneNumber);
    }

    return isValid;
  }

  private boolean isValidWithUsername(String password, String username) {
    return !password.contains(username);
  }

  private boolean isValidWithFirstName(String password, String firstName) {
    return !password.contains(firstName);
  }

  private boolean isValidWithLastName(String password, String lastName) {
    return !password.contains(lastName);
  }

  private boolean isValidWithEmail(String password, String email) {
    return !password.contains(email);
  }

  private boolean isValidWithPhoneNumber(String password, String phoneNumber) {
    return !password.contains(phoneNumber);
  }

}
