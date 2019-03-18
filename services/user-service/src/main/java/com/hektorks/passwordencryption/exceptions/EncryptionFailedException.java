package com.hektorks.passwordencryption.exceptions;

public class EncryptionFailedException extends RuntimeException {
  public EncryptionFailedException(Exception cause) {
    super("Error during password decryption.", cause);
  }
}