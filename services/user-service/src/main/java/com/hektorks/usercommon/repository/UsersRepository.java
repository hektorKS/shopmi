package com.hektorks.usercommon.repository;

import com.hektorks.usercommon.repository.mappers.UsersMapper;
import com.hektorks.exceptionhandling.RepositoryException;
import com.hektorks.usercommon.datamodel.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@AllArgsConstructor
public class UsersRepository {

  private final SqlSessionTemplate sqlSessionTemplate;

  public Integer createUser(User user) {
    try {
      UsersMapper usersMapper = sqlSessionTemplate.getMapper(UsersMapper.class);
      usersMapper.createUser(user);
      return user.getId();
    } catch (Exception exception) {
      log.warn("User insertion failed [{}].", user);
      throw new RepositoryException(exception);
    }
  }

  public User getUserById(Integer id) {
    try {
      UsersMapper usersMapper = sqlSessionTemplate.getMapper(UsersMapper.class);
      return usersMapper.selectUserById(id);
    } catch (Exception exception) {
      log.warn("Getting user by id [{}] failed.", id);
      throw new RepositoryException(exception);
    }
  }

}
