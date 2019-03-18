package com.hektorks.user.getuser;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class GetUserController {

  @GetMapping("/user")
  ResponseEntity<Void> getUser() {

    return ResponseEntity.ok(null);
  }

}
