/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.getuserbyid;

import com.hektorks.user.common.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class GetUserResponse {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String email;
  private final String phoneNumber;
  private final String countryCode;

  static GetUserResponse create(User user) {
    return new GetUserResponse(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getUsername(),
        user.getEmail(),
        user.getPhoneNumber(),
        user.getCountryCode()
    );
  }
}