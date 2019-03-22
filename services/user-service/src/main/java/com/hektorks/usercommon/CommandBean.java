package com.hektorks.usercommon;

public interface CommandBean<T, S> {
  S execute(T data);
}
