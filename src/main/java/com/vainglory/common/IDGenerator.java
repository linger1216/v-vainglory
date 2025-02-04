package com.vainglory.common;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.core.toolkit.Sequence;
import org.springframework.stereotype.Component;

import java.net.InetAddress;


/*
全局id生成器
 */


@Component
public class IDGenerator implements IdentifierGenerator {
  private final Sequence sequence;

  public IDGenerator() {
    this.sequence = new Sequence((InetAddress)null);
  }
  @Override
  public Number nextId(Object entity) {
    return sequence.nextId();
  }

  // 虽然是uuid名字,但实际上是前缀+雪花算法
  @Override
  public String nextUUID(Object entity) {
    String entityName = entity.getClass().getSimpleName();
    String prefix = entityName.toLowerCase() + ":";
    return prefix + sequence.nextId();
  }
}
