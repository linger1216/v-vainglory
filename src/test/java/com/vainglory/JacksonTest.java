package com.vainglory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vainglory.pojo.Tesla;
import org.junit.jupiter.api.Test;

public class JacksonTest {
  @Test
  public void testSingleLowerLetter() throws JsonProcessingException {
    // ObjectMapper 进行序列化和反序列化
    ObjectMapper mapper = new ObjectMapper();

    String teslaJson = """
        {
        	"id": "userid",
        	"name": "张三"
        }
        """;

    Tesla tesla1 = new Tesla();
    tesla1.setId("useri2d");
    tesla1.setName("张1");
    // 反序列化，将teslaJSON 转换成 tesla 对象
    Tesla tesla = mapper.readValue(teslaJson, Tesla.class);
    System.out.println("转换的 tesla 对象为：" + tesla);
  }
}
