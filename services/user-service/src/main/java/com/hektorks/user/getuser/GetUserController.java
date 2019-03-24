package com.hektorks.user.getuser;

import com.hektorks.exceptionhandling.CommandException;
import com.hektorks.user.common.CommandBean;
import com.hektorks.user.common.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class GetUserController {

  @Qualifier("GetUserByIdCommandBeanImpl")
  private final CommandBean<User, Integer> commandBean;

  @GetMapping("/user/{userId}")
  ResponseEntity getUser(@PathVariable Integer userId) {

    try {
      User user = commandBean.execute(userId);
      if (user == null) {
        return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok(GetUserResponse.create(user));
    } catch (
        CommandException exception) {
      return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
