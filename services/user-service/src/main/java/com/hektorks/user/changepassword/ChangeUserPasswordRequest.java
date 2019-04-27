/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import lombok.Data;
import lombok.ToString;
import lombok.ToString.Exclude;

import javax.validation.constraints.NotNull;

@Data
@ToString
class ChangeUserPasswordRequest {
  @NotNull(message = "Mandatory field oldPassword missing.")
  @Exclude
  private String oldPassword;
  @NotNull(message = "Mandatory field newPassword missing.")
  @Exclude
  private String newPassword;
}