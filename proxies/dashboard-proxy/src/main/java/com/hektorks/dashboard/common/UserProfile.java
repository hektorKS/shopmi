/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
/*
 * This class will be extended with some additional data about User.
 */
public class UserProfile {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String email;
  private final String phoneNumber;
  private final String countryCode;
}