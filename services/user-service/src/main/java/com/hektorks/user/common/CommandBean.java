package com.hektorks.user.common;

public interface CommandBean<T, S> {
  T execute(S data);
}
