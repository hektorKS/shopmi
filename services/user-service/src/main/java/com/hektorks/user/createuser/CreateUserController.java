package com.hektorks.user.createuser;

import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.LogicValidationException;
import com.hektorks.exceptionhandling.LogicValidationExceptionMapper;
import com.hektorks.exceptionhandling.RequestValidationExceptions;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class CreateUserController {

  private final CreateUserCommandBean createUserCommandBean;

  @PostMapping("/user")
  ResponseEntity createUser(@Valid @RequestBody CreateUserRequest createUserRequest, Errors errors) {
    if (errors.hasErrors()) {
      return ResponseEntity.badRequest().body(RequestValidationExceptions.fromContextErrors(errors));
    }
    try {
      CreateUserResponse createUserResponse = new CreateUserResponse(createUserCommandBean.execute(createUserRequest));
      return ResponseEntity.ok(createUserResponse);
    } catch (LogicValidationException exception) {
      return ResponseEntity.unprocessableEntity().body(LogicValidationExceptionMapper.toJson(exception));
    } catch (CommandException exception) {
      return new ResponseEntity<>(exception.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
