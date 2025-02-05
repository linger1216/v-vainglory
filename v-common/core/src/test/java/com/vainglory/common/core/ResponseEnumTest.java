package com.vainglory.common.core;

import com.vainglory.common.core.enums.ResponseEnum;
import org.junit.jupiter.api.Test;

public class ResponseEnumTest {

  @Test
  public void Test_ResponseEnum() {
    System.out.println(ResponseEnum.RC1500.getMsg());
  }

}
