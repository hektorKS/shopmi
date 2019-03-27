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
  @Null
  private Integer userId;
  @NotNull
  private String oldPassword;
  @NotNull
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
