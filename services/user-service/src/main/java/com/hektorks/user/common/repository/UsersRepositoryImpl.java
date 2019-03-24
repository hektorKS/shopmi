package com.hektorks.user.common.repository;

import com.hektorks.exceptionhandling.RepositoryException;
import com.hektorks.user.common.User;
import com.hektorks.user.common.repository.mappers.UsersMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@AllArgsConstructor
class UsersRepositoryImpl implements UsersRepository {

  private final SqlSessionTemplate sqlSessionTemplate;

  @Override
  public Integer createUser(User user) {
    try {
      UsersMapper usersMapper = sqlSessionTemplate.getMapper(UsersMapper.class);
      usersMapper.createUser(user);
      return user.getId();
    } catch (Exception exception) {
      log.warn("User insertion failed [{}].", user, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public boolean userExistsByUsername(String username) {
    try {
      UsersMapper usersMapper = sqlSessionTemplate.getMapper(UsersMapper.class);
      int result =  usersMapper.countByUsername(username);
      return result > 0;
    } catch (Exception exception) {
      log.warn("Checking if user with username [{}] exists failed.", username, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public User getUserById(Integer id) {
    try {
      UsersMapper usersMapper = sqlSessionTemplate.getMapper(UsersMapper.class);
      return usersMapper.selectUserById(id);
    } catch (Exception exception) {
      log.warn("Getting user by id [{}] failed.", id, exception);
      throw new RepositoryException(exception);
    }
  }

}
