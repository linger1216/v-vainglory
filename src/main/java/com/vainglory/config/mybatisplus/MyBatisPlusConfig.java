package com.vainglory.config.mybatisplus;

/*
mybatis-plus 配置类
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.vainglory.factory.YmlPropertySourceFactory;
import com.vainglory.handler.mybatisplus.InjectMetaObjectHandler;
import com.vainglory.handler.mybatisplus.PrefixIdentifierGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@MapperScan("${mybatis-plus.mapperPackage}")
public class MyBatisPlusConfig {
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

    // 分页插件
    // DbType.POSTGRE_SQL 不写参数会自动判断
    PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
    // 这是 MyBatis Plus 分页插件中的一个设置，用于处理分页查询时超出最大页数的情况。当设置为 true 时，
    // 如果请求的页面大于最大页码，它将默认跳转到第一页。这个设置可以防止在分页查询中出现空数据页的问题
    paginationInnerInterceptor.setOverflow(true);
    paginationInnerInterceptor.setMaxLimit(500L);
    interceptor.addInnerInterceptor(paginationInnerInterceptor);

    // 乐观锁（version）
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());

    // 防止全表更新与删除
    interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());

    // TODO: 后续在考虑留不留
    // 全局Status过滤
    // interceptor.addInnerInterceptor(new StatusInterceptor());
    return interceptor;
  }

  // 全局的Handler
  // 配置字段自动填充
  @Bean
  public MetaObjectHandler metaObjectHandler() {
    return new InjectMetaObjectHandler();
  }

  // 配置ID生成器
  @Bean
  public IdentifierGenerator identifierGenerator() {
    return new PrefixIdentifierGenerator();
  }

}
