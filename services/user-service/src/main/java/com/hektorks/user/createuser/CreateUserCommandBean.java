package com.hektorks.user.createuser;

import com.hektorks.usercommon.CommandBean;
import com.hektorks.usercommon.datamodel.User;
import com.hektorks.usercommon.passwordencryption.EncryptedPassword;
import com.hektorks.usercommon.passwordencryption.PasswordEncryptionBean;
import com.hektorks.usercommon.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class CreateUserCommandBean implements CommandBean<CreateUserRequest, Integer> {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;

  @Override
  public Integer execute(CreateUserRequest createUserRequest) {

    EncryptedPassword encryptedPassword = passwordEncryptionBean.encrypt(createUserRequest.getPassword());

    User user = new User(
        null,
        createUserRequest.getFirstName(),
        createUserRequest.getLastName(),
        createUserRequest.getUsername(),
        encryptedPassword.getPassword(),
        encryptedPassword.getSalt(),
        createUserRequest.getEmail(),
        createUserRequest.getPhoneNumber(),
        createUserRequest.getCountryCode()
    );

    Integer userId = usersRepository.createUser(user);
    log.info("User created with id [{}].", userId);
    return userId;
  }
}
