package com.hektorks.user.common.passwordencryption.exceptions;

public class DecryptionFailedException extends RuntimeException {
  public DecryptionFailedException(Exception cause) {
    super("Error during password decryption.", cause);
  }
}
