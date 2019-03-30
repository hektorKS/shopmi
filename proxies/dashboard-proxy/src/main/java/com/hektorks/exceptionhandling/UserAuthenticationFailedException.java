/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.exceptionhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAuthenticationFailedException extends RuntimeException {
  private final String reason;

  public UserAuthenticationFailedException(Object identifier, String reason) {
    super("User " + identifier + " authentication failed");
    this.reason = reason;
  }
}
