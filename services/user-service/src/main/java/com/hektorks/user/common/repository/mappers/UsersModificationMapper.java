/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository.mappers;

import com.hektorks.user.common.model.User;
import com.hektorks.user.common.model.UserData;
import com.hektorks.user.common.model.UserPassword;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersModificationMapper {

  void createUser(User user);

  void updateUserData(UserData userData);

  void updateUserPassword(UserPassword userPassword);
}
