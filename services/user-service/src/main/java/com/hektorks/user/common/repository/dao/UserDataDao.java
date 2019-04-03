/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
@AllArgsConstructor
public class UserDataDao {
  private Integer id;
  private String firstName;
  private String lastName;
  private String username;
  private String email;
  private String phoneNumber;
  private String countryCode;
}