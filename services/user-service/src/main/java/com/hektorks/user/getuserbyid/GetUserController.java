package com.hektorks.user.getuserbyid;

import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.exceptionhandling.ResourceNotFoundException;
import com.hektorks.user.common.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
class GetUserController {

  private final GetUserByIdCommandBean getUserByIdCommandBean;

  @GetMapping("/user/{userId}")
  ResponseEntity getUser(@PathVariable Integer userId) {
    try {
      User user = getUserByIdCommandBean.execute(userId);
      return ResponseEntity.ok(GetUserResponse.create(user));
    } catch (ResourceNotFoundException exception) {
      return ResponseEntity.notFound().build();
    } catch (CommandException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
