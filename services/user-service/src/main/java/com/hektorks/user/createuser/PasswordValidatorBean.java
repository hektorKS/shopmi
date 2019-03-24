package com.hektorks.user.createuser.validation;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.user.common.BusinessValidatorBean;
import com.hektorks.user.createuser.CreateUserRequest;

class PasswordValidatorBean implements BusinessValidatorBean<CreateUserRequest> {

  private static final int PASSWORD_MIN_LENGTH = 8;
  private static final int PASSWORD_MAX_LENGTH = 32;
  private static final String PASSWORD_PATTERN = String
      .format("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{%d,%d}$", PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH);

  @Override
  public void validate(CreateUserRequest request) {
    boolean isValid = isValidPattern(request.getPassword());

    if (isValid) {
      isValid = isValidWithFields(
          request.getPassword(),
          request.getFirstName(),
          request.getLastName(),
          request.getUsername(),
          request.getEmail()
      );
    }

    if (!isValid) {
      throw new BusinessValidationException(
          new StringBuilder()
              .append("Password must be from ")
              .append(PASSWORD_MIN_LENGTH)
              .append(" to ")
              .append(PASSWORD_MAX_LENGTH)
              .append(" signs long.")
              .append("It cannot contain white signs.")
              .append("It cannot contain any of username, firstName, lastName, email.")
              .append("It must contain at least one lowercase letter, uppercase letter and digit.")
              .toString(),
          "password"
      );
    }
  }

  private boolean isValidPattern(String password) {
    return password.matches(PASSWORD_PATTERN);
  }


  private boolean isValidWithFields(String password, String firstName, String lastName, String username, String email) {
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

}
