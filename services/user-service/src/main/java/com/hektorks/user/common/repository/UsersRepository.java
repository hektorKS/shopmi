/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository;

import com.hektorks.user.common.model.User;
import com.hektorks.user.common.model.UserData;
import com.hektorks.user.common.model.UserPassword;

public interface UsersRepository {

  Integer createUser(User user);

  void updateUserData(UserData userData);

  void updateUserPassword(UserPassword userPassword);

  User getUserById(Integer id);

  User getUserByUsername(String username);

  boolean userExistsById(Integer id);

  boolean userExistsByUsername(String username);

  boolean userExistsByEmail(String email);
}