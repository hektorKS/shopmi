/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository;

import com.hektorks.user.common.User;
import com.hektorks.user.common.repository.dao.UserDataDao;
import com.hektorks.user.common.repository.dao.UserPasswordDao;

public interface UsersRepository {

  Integer createUser(User user);

  void updateUserData(UserDataDao userDataDao);

  void updateUserPassword(UserPasswordDao userPasswordDao);

  User getUserById(Integer id);

  User getUserByUsername(String username);

  boolean userExistsById(Integer id);

  boolean userExistsByUsername(String username);

  boolean userExistsByEmail(String email);
}