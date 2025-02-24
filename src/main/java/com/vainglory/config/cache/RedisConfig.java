package com.vainglory.config.cache;

import cn.hutool.core.util.ObjectUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.vainglory.handler.cache.KeyPrefixHandler;
import com.vainglory.handler.cache.RedisExceptionHandler;
import com.vainglory.properties.cache.RedissonProperties;
import com.vainglory.utils.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.CompositeCodec;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.redisson.spring.starter.RedissonAutoConfigurationCustomizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.VirtualThreadTaskExecutor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * redis配置
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(RedissonProperties.class)
public class RedisConfig {

  @Autowired
  private RedissonProperties redissonProperties;

  /*
    Java真是又臭又长
   */
  @Bean
  public RedissonAutoConfigurationCustomizer redissonCustomizer() {
    return config -> {
      JavaTimeModule javaTimeModule = new JavaTimeModule();
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatter));
      javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatter));

      ObjectMapper om = new ObjectMapper();
      om.registerModule(javaTimeModule);
      om.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
      // 指定序列化输入的类型，类必须是非final修饰的。序列化时将对象全类名一起保存下来
      om.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
//            LoggerFactory.useSlf4jLogging(true);
//            FuryCodec furyCodec = new FuryCodec();
//            CompositeCodec codec = new CompositeCodec(StringCodec.INSTANCE, furyCodec, furyCodec);
      TypedJsonJacksonCodec jsonCodec = new TypedJsonJacksonCodec(Object.class, om);
      // 组合序列化 key 使用 String 内容使用通用 json 格式
      CompositeCodec codec = new CompositeCodec(StringCodec.INSTANCE, jsonCodec, jsonCodec);
      config.setThreads(redissonProperties.getThreads())
        .setNettyThreads(redissonProperties.getNettyThreads())
        // 缓存 Lua 脚本 减少网络传输(redisson 大部分的功能都是基于 Lua 脚本实现)
        .setUseScriptCache(true)
        .setCodec(codec);

      // 这是 Threading 枚举中的一个方法，用于检查当前应用是否启用了虚拟线程
      if (SpringUtils.isVirtual()) {
        config.setNettyExecutor(new VirtualThreadTaskExecutor("redisson-"));
      }

      RedissonProperties.SingleServerConfig singleServerConfig = redissonProperties.getSingleServerConfig();
      if (ObjectUtil.isNotNull(singleServerConfig)) {
        // 使用单机模式
        config.useSingleServer()
          //设置redis key前缀
          .setNameMapper(new KeyPrefixHandler(redissonProperties.getKeyPrefix()))
          .setTimeout(singleServerConfig.getTimeout())
          .setClientName(singleServerConfig.getClientName())
          .setIdleConnectionTimeout(singleServerConfig.getIdleConnectionTimeout())
          .setSubscriptionConnectionPoolSize(singleServerConfig.getSubscriptionConnectionPoolSize())
          .setConnectionMinimumIdleSize(singleServerConfig.getConnectionMinimumIdleSize())
          .setConnectionPoolSize(singleServerConfig.getConnectionPoolSize());
      }
      // 集群配置方式 参考下方注释
      RedissonProperties.ClusterServersConfig clusterServersConfig = redissonProperties.getClusterServersConfig();
      if (ObjectUtil.isNotNull(clusterServersConfig)) {
        config.useClusterServers()
          //设置redis key前缀
          .setNameMapper(new KeyPrefixHandler(redissonProperties.getKeyPrefix()))
          .setTimeout(clusterServersConfig.getTimeout())
          .setClientName(clusterServersConfig.getClientName())
          .setIdleConnectionTimeout(clusterServersConfig.getIdleConnectionTimeout())
          .setSubscriptionConnectionPoolSize(clusterServersConfig.getSubscriptionConnectionPoolSize())
          .setMasterConnectionMinimumIdleSize(clusterServersConfig.getMasterConnectionMinimumIdleSize())
          .setMasterConnectionPoolSize(clusterServersConfig.getMasterConnectionPoolSize())
          .setSlaveConnectionMinimumIdleSize(clusterServersConfig.getSlaveConnectionMinimumIdleSize())
          .setSlaveConnectionPoolSize(clusterServersConfig.getSlaveConnectionPoolSize())
          .setReadMode(clusterServersConfig.getReadMode())
          .setSubscriptionMode(clusterServersConfig.getSubscriptionMode());
      }
      log.info("初始化 redis 配置");
    };
  }

  /**
   * 异常处理器
   */
  @Bean
  public RedisExceptionHandler redisExceptionHandler() {
    return new RedisExceptionHandler();
  }

}
