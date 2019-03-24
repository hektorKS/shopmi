package com.hektorks.user.common;

public interface BusinessValidatorBean<T> {
  void validate(T data);
}
