package com.hektorks.user.createuser;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
class CreateUserResponse {
  private final UUID userId;
}
