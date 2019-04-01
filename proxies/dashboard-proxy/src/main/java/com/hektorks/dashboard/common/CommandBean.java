/*
 * Copyright (c) 2019 Konrad Szymański. All rights reserved.
 *
 */

package com.hektorks.dashboard.common;

public interface CommandBean<T, S> {
  T execute(S data);
}