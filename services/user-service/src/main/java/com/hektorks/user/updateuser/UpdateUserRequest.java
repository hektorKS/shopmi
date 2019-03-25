package com.hektorks.user.updateuser;

import lombok.Data;

import javax.validation.constraints.Null;

@Data
class UpdateUserRequest {
  @Null
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String phoneNumber;
  private String countryCode;

  public boolean isNotEmpty() {
    return firstName != null ||
        lastName != null ||
        username != null ||
        email != null ||
        phoneNumber != null ||
        countryCode != null;
  }
}
