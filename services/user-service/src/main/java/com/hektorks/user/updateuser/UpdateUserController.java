package com.hektorks.user.updateuser;

import com.hektorks.exceptionhandling.BusinessValidationException;
import com.hektorks.exceptionhandling.BusinessValidationExceptionMapper;
import com.hektorks.exceptionhandling.CommandException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class UpdateUserController {

  private final UpdateUserByIdCommandBean updateUserByIdCommandBean;

  @PatchMapping("/user/{userId}")
  ResponseEntity updateUser(@PathVariable Integer userId, @RequestBody UpdateUserRequest updateUserRequest) {
    try {
      updateUserRequest.setId(userId);
      updateUserByIdCommandBean.execute(updateUserRequest);
      return ResponseEntity.ok().body(null);
    } catch (BusinessValidationException exception) {
      return ResponseEntity.unprocessableEntity().body(BusinessValidationExceptionMapper.toMap(exception));
    } catch (CommandException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
