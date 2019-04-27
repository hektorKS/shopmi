/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.user.common.validation;

public abstract class BusinessValidatorTemplateBean<T> implements BusinessValidatorBean<T> {
  @Override
  public final void validate(T data) {
    if (this.appliesTo(data)) {
      this.process(data);
    }
  }

  abstract boolean appliesTo(T data);

  abstract void process(T data);
}