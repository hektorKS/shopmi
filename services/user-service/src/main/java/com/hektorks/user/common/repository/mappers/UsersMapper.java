package com.hektorks.user.common.repository.mappers;

import com.hektorks.user.common.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

  void createUser(User user);

  User selectUserById(Integer id);

  int countById(Integer id);

  int countByUsername(String username);

  int countByEmail(String email);
}
