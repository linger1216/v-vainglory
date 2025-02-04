package com.vainglory;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.DataPermissionInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.vainglory.common.StatusInterceptor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@OpenAPIDefinition(
    info = @Info(
        title = "My API",
        version = "1.0.0",
        description = "This is my first API using Swagger 3"
    ),
    servers = {
        @Server(url = "http://localhost:8080/api", description = "Local development server")
    }
)


@SpringBootApplication
@MapperScan("com.vainglory.mapper")
public class VaingloryApplication {

  public static void main(String[] args) {
    SpringApplication.run(VaingloryApplication.class, args);
  }

  // 配置mybatis-plus插件
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    // 分页插件
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.POSTGRE_SQL));
    // 乐观锁（version）
    interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
    // 防止全表更新与删除
    interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
    // 状态插件 添加status=1
    interceptor.addInnerInterceptor(new StatusInterceptor());
    return interceptor;
  }
}
