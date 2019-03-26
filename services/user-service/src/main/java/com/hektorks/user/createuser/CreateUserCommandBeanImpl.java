package com.hektorks.user.createuser;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.user.common.User;
import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.createuser.exceptions.CreateUserCommandException;
import com.hektorks.user.createuser.exceptions.EmailAlreadyUsedException;
import com.hektorks.user.createuser.exceptions.UserExistsException;
import com.hektorks.user.userexists.UserExistsByEmailCommandBean;
import com.hektorks.user.userexists.UserExistsByUsernameCommandBean;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class CreateUserCommandBeanImpl implements CreateUserCommandBean {

  private final UsersRepository usersRepository;
  private final PasswordEncryptionBean passwordEncryptionBean;
  private final CreateUserRequestValidatorBean createUserRequestValidatorBean;
  private final UserExistsByEmailCommandBean userExistsByEmailCommandBean;
  private final UserExistsByUsernameCommandBean userExistsByUsernameCommandBean;

  @Override
  public Integer execute(CreateUserRequest createUserRequest) {
    createUserRequestValidatorBean.validate(createUserRequest);
    try {
      if (userExistsByUsernameCommandBean.execute(createUserRequest.getUsername())) {
        log.info("Username [{}] is already used.", createUserRequest.getUsername());
        throw new UserExistsException(createUserRequest.getUsername());
      }

      if (userExistsByEmailCommandBean.execute(createUserRequest.getEmail())) {
        log.info("Email {} is already used.", createUserRequest.getEmail());
        throw new EmailAlreadyUsedException(createUserRequest.getEmail());
      }

      User user = new User(
          null,
          createUserRequest.getFirstName(),
          createUserRequest.getLastName(),
          createUserRequest.getUsername(),
          passwordEncryptionBean.encrypt(createUserRequest.getPassword()),
          createUserRequest.getEmail(),
          createUserRequest.getPhoneNumber(),
          createUserRequest.getCountryCode()
      );

      Integer userId = usersRepository.createUser(user);
      log.info("User created with id [{}].", userId);
      return userId;
    } catch (BusinessValidationException exception) {
      log.info("Business validation failed for create user request [{}].", createUserRequest);
      throw exception;
    } catch (Exception exception) {
      log.warn("Creating user failed", exception);
      throw new CreateUserCommandException(exception);
    }
  }
}
