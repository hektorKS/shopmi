/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.model;

import com.hektorks.user.common.passwordencryption.EncryptedPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UserPassword {
  private Integer id;
  private EncryptedPassword encryptedPassword;
}