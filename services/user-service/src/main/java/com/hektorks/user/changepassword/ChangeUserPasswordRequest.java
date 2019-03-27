/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.changepassword;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
class ChangeUserPasswordRequest {
  @Null(message = "Field userId must be null.")
  private Integer userId;
  @NotNull(message = "Mandatory field oldPassword missing.")
  private String oldPassword;
  @NotNull(message = "Mandatory field newPassword missing.")
  private String newPassword;

  @Override
  public String toString() {
    return "ChangeUserPasswordRequest{" +
        "userId=" + userId +
        ", oldPassword='" + "XXX" + '\'' +
        ", newPassword='" + "YYY" + '\'' +
        '}';
  }
}
