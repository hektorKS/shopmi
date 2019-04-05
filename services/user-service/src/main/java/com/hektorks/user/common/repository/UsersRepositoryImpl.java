/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.repository;

import com.hektorks.exceptionhandling.RepositoryException;
import com.hektorks.user.common.model.User;
import com.hektorks.user.common.model.UserData;
import com.hektorks.user.common.model.UserPassword;
import com.hektorks.user.common.repository.mappers.UsersModificationMapper;
import com.hektorks.user.common.repository.mappers.UsersSelectionMapper;
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
      UsersModificationMapper usersModificationMapper = sqlSessionTemplate.getMapper(UsersModificationMapper.class);
      usersModificationMapper.createUser(user);
      return user.getId();
    } catch (Exception exception) {
      log.warn("User insertion failed [{}].", user, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public void updateUserData(UserData userData) {
    try {
      UsersModificationMapper usersModificationMapper = sqlSessionTemplate.getMapper(UsersModificationMapper.class);
      usersModificationMapper.updateUserData(userData);
    } catch (Exception exception) {
      log.warn("Updating user data failed [{}].", userData, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public void updateUserPassword(UserPassword userPassword) {
    try {
      UsersModificationMapper usersModificationMapper = sqlSessionTemplate.getMapper(UsersModificationMapper.class);
      usersModificationMapper.updateUserPassword(userPassword);
    } catch (Exception exception) {
      log.warn("Updating user password failed [{}].", userPassword, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public User getUserById(Integer id) {
    try {
      UsersSelectionMapper usersSelectionMapper = sqlSessionTemplate.getMapper(UsersSelectionMapper.class);
      return usersSelectionMapper.selectUserById(id);
    } catch (Exception exception) {
      log.warn("Getting user by id [{}] failed.", id, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public User getUserByUsername(String username) {
    try {
      UsersSelectionMapper usersSelectionMapper = sqlSessionTemplate.getMapper(UsersSelectionMapper.class);
      return usersSelectionMapper.selectUserByUsername(username);
    } catch (Exception exception) {
      log.warn("Getting user by username [{}] failed.", username, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public boolean userExistsById(Integer id) {
    try {
      UsersSelectionMapper usersSelectionMapper = sqlSessionTemplate.getMapper(UsersSelectionMapper.class);
      return usersSelectionMapper.countById(id) > 0;
    } catch (Exception exception) {
      log.warn("Checking if user exists by id [{}] failed.", id, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public boolean userExistsByUsername(String username) {
    try {
      UsersSelectionMapper usersSelectionMapper = sqlSessionTemplate.getMapper(UsersSelectionMapper.class);
      return usersSelectionMapper.countByUsername(username) > 0;
    } catch (Exception exception) {
      log.warn("Checking if user with username [{}] exists failed.", username, exception);
      throw new RepositoryException(exception);
    }
  }

  @Override
  public boolean userExistsByEmail(String email) {
    try {
      UsersSelectionMapper usersSelectionMapper = sqlSessionTemplate.getMapper(UsersSelectionMapper.class);
      return usersSelectionMapper.countByEmail(email) > 0;
    } catch (Exception exception) {
      log.warn("Checking if user with email [{}] exists failed.", email, exception);
      throw new RepositoryException(exception);
    }
  }
}