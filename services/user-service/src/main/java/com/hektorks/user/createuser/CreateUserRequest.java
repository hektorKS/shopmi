package com.hektorks.user.createuser;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

@Data
class CreateUserRequest {

  @NotBlank(message = "Mandatory field firstName missing.")
  private String firstName;

  @NotBlank(message = "Mandatory field lastName missing.")
  private String lastName;

  @NotBlank(message = "Mandatory field username missing.")
  private String username;

  @NotBlank(message = "Mandatory field password missing.")
  private String password;

  @Email(message = "Invalid email format.")
  @NotBlank(message = "Mandatory field email missing.")
  private String email;

  @NotBlank(message = "Mandatory field phoneNumber missing.")
  @Pattern(regexp = "^+(?:[0-9]?){6,14}[0-9]$", message = "Phone number format ^+(?:[0-9]?){6,14}[0-9]$.")
  private String phoneNumber;

  @Length(min = 2, max = 2, message = "Country code must be in ISO 3166-1 alpha-2 format.")
  @NotBlank(message = "Mandatory field countryCode missing.")
  private String countryCode;
}
