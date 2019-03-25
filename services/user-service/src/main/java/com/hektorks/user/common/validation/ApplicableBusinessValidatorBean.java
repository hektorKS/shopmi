package com.hektorks.user.common.validation;

public interface ApplicableBusinessValidatorBean<T> extends BusinessValidatorBean<T> {
  boolean isApplicable(T data);
}
