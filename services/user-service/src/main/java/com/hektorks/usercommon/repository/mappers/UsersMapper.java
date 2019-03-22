package com.hektorks.usercommon.repository.mappers;

import com.hektorks.usercommon.datamodel.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UsersMapper {

  void createUser(User user);

  User selectUserById(Integer id);
}
