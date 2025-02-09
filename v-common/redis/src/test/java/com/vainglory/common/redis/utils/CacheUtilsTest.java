package com.vainglory.common.redis.utils;

import com.vainglory.common.redis.config.RedisConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {RedisConfig.class})
public class CacheUtilsTest {
  @Test
  public void testCache(){
    CacheUtils.put("cachename", "key", "value");
    // get
    Object o = CacheUtils.get("cachename", "key");
    System.out.println(o);
  }
}
