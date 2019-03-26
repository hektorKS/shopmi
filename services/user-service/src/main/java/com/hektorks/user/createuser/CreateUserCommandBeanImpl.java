package com.hektorks.user.createuser;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.user.common.User;
import com.hektorks.user.common.passwordencryption.PasswordEncryptionBean;
import com.hektorks.user.common.repository.UsersRepository;
import com.hektorks.user.common.validation.BusinessValidatorBean;
import com.hektorks.user.createuser.exceptions.CreateUserCommandException;
import com.hektorks.user.createuser.exceptions.EmailAlreadyUsedException;
import com.hektorks.user.createuser.exceptions.UserExistsException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
class CreateUserCommandBeanImpl implements CreateUserCommandBean {

  private final PasswordEncryptionBean passwordEncryptionBean;
  private final BusinessValidatorBean<CreateUserRequest> businessValidatorBean;
  private final UsersRepository usersRepository;

  @Override
  public Integer execute(CreateUserRequest createUserRequest) {
    businessValidatorBean.validate(createUserRequest);
    try {
      ///TODO this to command, so it could be reused userExistsByUsernameAndEmailCommand-> execute
      if (usersRepository.userExistsByUsername(createUserRequest.getUsername())) {
        log.info("User with username [{}] already exists.", createUserRequest.getUsername());
        throw new UserExistsException(createUserRequest.getUsername());
      }

      if (usersRepository.userExistsByEmail(createUserRequest.getEmail())) {
        log.info("Email {} is already used", createUserRequest.getEmail());
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
      throw new CreateUserCommandException(exception);
    }
  }
}
