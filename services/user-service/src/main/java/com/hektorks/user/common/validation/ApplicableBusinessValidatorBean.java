/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

public interface ApplicableBusinessValidatorBean<T> extends BusinessValidatorBean<T> {
  boolean isApplicable(T data);
}
