/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository.mappers;

import com.hektorks.user.common.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersSelectionMapper {

  User selectUserById(Integer id);

  User selectUserByUsername(String username);

  int countById(Integer id);

  int countByUsername(String username);

  int countByEmail(String email);
}
