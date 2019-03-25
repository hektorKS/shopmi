package com.hektorks.user.getuser;

import com.hektorks.user.common.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetUserResponse {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String username;
  private final String email;
  private final String phoneNumber;
  private final String countryCode;

  public static GetUserResponse create(User user) {
    return new GetUserResponse(
        user.getId(),
        user.getFirstName(),
        user.getLastName(),
        user.getUsername(),
        user.getEmail(),
        user.getPhoneNumber(),
        user.getCountryCode()
    );
  }
}
