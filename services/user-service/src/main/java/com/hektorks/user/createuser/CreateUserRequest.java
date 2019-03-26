package com.hektorks.user.createuser;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
class CreateUserRequest {

  @NotNull(message = "Mandatory field firstName missing.")
  private String firstName;
  @NotNull(message = "Mandatory field lastName missing.")
  private String lastName;
  @NotNull(message = "Mandatory field username missing.")
  private String username;
  @NotNull(message = "Mandatory field password missing.")
  private String password;
  @NotNull(message = "Mandatory field email missing.")
  private String email;
  private String phoneNumber;
  private String countryCode;

  @Override
  public String toString() {
    return new StringBuilder()
        .append("CreateUserRequest(")
        .append("firstName = ")
        .append(firstName)
        .append(", ")
        .append("lastName = ")
        .append(lastName)
        .append(", ")
        .append("username = ")
        .append(username)
        .append(", ")
        .append("password = ")
        .append("XXX")
        .append(", ")
        .append("email = ")
        .append(email)
        .append(", ")
        .append("phoneNumber = ")
        .append(phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null)
        .append(", ")
        .append("countryCode = ")
        .append(countryCode)
        .append(")")
        .toString();
  }
}
