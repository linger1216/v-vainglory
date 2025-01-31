package com.vainglory.common;

/*
  是用thread local 来保存状态
  大部分的场景都是获取status=1的状态，极个别的情况需要获取status=0的状态
  用这个来偷懒.
 */
public class StatusConditionHelper {
  private static final ThreadLocal<Boolean> skipStatusCondition = ThreadLocal.withInitial(() -> false);

  public static void setSkipStatusCondition(boolean skip) {
    skipStatusCondition.set(skip);
  }

  public static boolean isSkipStatusCondition() {
    return skipStatusCondition.get();
  }

  public static void removeStatusCondition() {
    skipStatusCondition.remove();
  }
}
