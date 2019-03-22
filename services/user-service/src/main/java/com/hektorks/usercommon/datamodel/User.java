package com.hektorks.usercommon.datamodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User {
  private final Integer id;
  private final String firstName;
  private final String lastName;
  private final String username;
//  TODO here could be EncryptedPassword object
  private final byte[] password;
  private final byte[] salt;
  private final String email;
  private final String phoneNumber;
  private final String countryCode;
}
