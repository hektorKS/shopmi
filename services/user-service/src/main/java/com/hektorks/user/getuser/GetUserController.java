package com.hektorks.user.getuser;

import com.hektorks.usercommon.repository.UsersRepository;
import com.hektorks.usercommon.datamodel.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class GetUserController {

  private final UsersRepository usersRepository;

  @GetMapping("/user/{userId}")
  ResponseEntity<User> getUser(@PathVariable Integer userId) {
//    TODO this must be refactored to map response without password
    return ResponseEntity.ok(usersRepository.getUserById(userId));
  }

}
