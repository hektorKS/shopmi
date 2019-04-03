/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

public interface PhoneNumberBusinessValidatorBean extends ApplicableBusinessValidatorBean<String> {
  @Override
  boolean isApplicable(String data);

  @Override
  void validate(String data);
}