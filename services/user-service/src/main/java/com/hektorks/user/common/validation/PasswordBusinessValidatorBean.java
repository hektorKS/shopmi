/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

public interface PasswordBusinessValidatorBean extends ApplicableBusinessValidatorBean<PasswordValidationEntity> {
  @Override
  boolean isApplicable(PasswordValidationEntity data);

  @Override
  void validate(PasswordValidationEntity data);
}