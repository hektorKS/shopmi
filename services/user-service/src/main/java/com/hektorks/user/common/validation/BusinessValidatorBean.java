package com.hektorks.user.common.validation;

public interface BusinessValidatorBean<T> {
  void validate(T data);
}
