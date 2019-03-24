package com.hektorks.user.createuser;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserRequest {

  @NotBlank(message = "Mandatory field firstName missing.")
  private String firstName;
  @NotBlank(message = "Mandatory field lastName missing.")
  private String lastName;
  @NotBlank(message = "Mandatory field username missing.")
  private String username;
  @NotBlank(message = "Mandatory field password missing.")
  private String password;
  @NotBlank(message = "Mandatory field email missing.")
  private String email;
  private String phoneNumber;
  private String countryCode;

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder
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
        .append(")");
    return stringBuilder.toString();
  }
}
