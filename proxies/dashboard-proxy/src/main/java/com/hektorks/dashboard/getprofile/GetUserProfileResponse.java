/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.getprofile;

import com.hektorks.dashboard.common.UserProfile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class GetUserProfileResponse {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String email;
  private final String phoneNumber;
  private final String countryCode;

  static GetUserProfileResponse create(UserProfile userProfile) {
    return new GetUserProfileResponse(
        userProfile.getId(),
        userProfile.getFirstName(),
        userProfile.getLastName(),
        userProfile.getUsername(),
        userProfile.getEmail(),
        userProfile.getPhoneNumber(),
        userProfile.getCountryCode()
    );
  }

}
