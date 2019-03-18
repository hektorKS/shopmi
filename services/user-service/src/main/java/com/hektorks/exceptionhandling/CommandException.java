package com.hektorks.exceptionhandling;

public class CommandException extends RuntimeException {
  public CommandException(String message, Throwable cause) {
    super(message, cause);
  }
}
