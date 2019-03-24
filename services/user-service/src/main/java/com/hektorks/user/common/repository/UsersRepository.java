package com.hektorks.user.common.repository;

import com.hektorks.user.common.User;

public interface UsersRepository {

  Integer createUser(User user);

  User getUserById(Integer id);

  boolean userExistsByUsername(String username);

  boolean userExistsByEmail(String email);
}
