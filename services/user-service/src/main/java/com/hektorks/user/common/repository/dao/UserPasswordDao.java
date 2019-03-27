/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository.dao;

import com.hektorks.user.common.passwordencryption.EncryptedPassword;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPasswordDao {
  private Integer id;
  private EncryptedPassword encryptedPassword;
}
