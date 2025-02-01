package com.vainglory.common;


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