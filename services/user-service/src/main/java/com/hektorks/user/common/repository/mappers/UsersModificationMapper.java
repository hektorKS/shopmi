/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository.mappers;

import com.hektorks.user.common.User;
import com.hektorks.user.common.repository.dao.UserDataDao;
import com.hektorks.user.common.repository.dao.UserPasswordDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersModificationMapper {

  void createUser(User user);

  void updateUserData(UserDataDao userDataDao);

  void updateUserPassword(UserPasswordDao userPasswordDao);
}
