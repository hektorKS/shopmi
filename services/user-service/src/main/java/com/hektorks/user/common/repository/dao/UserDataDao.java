/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserDataDao {
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String phoneNumber;
  private String countryCode;

  @Override
  public String toString() {
    return "UserDataDao{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + (phoneNumber != null ? phoneNumber.replaceAll("\\d", "X") : null) + '\'' +
        ", countryCode='" + countryCode + '\'' +
        '}';
  }
}
