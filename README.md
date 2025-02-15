主键自定义生成，表名+符号+雪花
自动DDL创建表

- deletedAt，可以调整为时间
- dto转pojo，有个东西叫ModelMapper
'

全局id的生成

数据权限的拦截器
status的拦截器

自定义注解，让拦截器生效或不生效

用户权限的设计

时间戳
https://www.cnblogs.com/hxysg/p/17772275.html

table-prefix TableName的坑

lombok的问题，特么最终要加这个 f**
```
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <annotationProcessorPaths>
            <path>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
              <version>1.18.36</version>
              <scope>provided</scope>
            </path>
          </annotationProcessorPaths>
        </configuration>
      </plugin>
```




增加了数据库初始化
sql:
init:
encoding: utf-8
mode: always
platform: auto
schema-locations:
- classpath:db/schema-user.sql
data-locations:
- classpath:db/data-user.sql


package com.vainglory.advice;

import com.vainglory.common.R;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ControllerException {
@ExceptionHandler({BindException.class})
public R MethodArgumentNotValidExceptionHandler(BindException e) {
// 从异常对象中拿到ObjectError对象
List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
//        String defaultMessage = objectError.getDefaultMessage();
return new R(500, "");
}
}



package com.vainglory.advice;

import com.vainglory.common.R;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ParamException {

@ExceptionHandler({MethodArgumentNotValidException.class})
@ResponseStatus(HttpStatus.BAD_REQUEST)
public R handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
BindingResult bindingResult = ex.getBindingResult();
StringBuilder sb = new StringBuilder("校验失败:");
for (FieldError fieldError : bindingResult.getFieldErrors()) {
sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
}
String msg = sb.toString();
return R.F(HttpStatus.BAD_REQUEST.value(),msg);
}

@ExceptionHandler({ConstraintViolationException.class})
@ResponseStatus(HttpStatus.BAD_REQUEST)
public R handleConstraintViolationException(ConstraintViolationException ex) {
return R.F(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
}
}




server:
port: 8080
servlet:
context-path: /vg/v1
tomcat:
uri-encoding: UTF-8

spring:
application:
name: v-vainglory
datasource:
type: com.alibaba.druid.pool.DruidDataSource
druid:
url: jdbc:postgresql://localhost:5432/lid
driver-class-name: org.postgresql.Driver
username: postgres
password: ""
initial-size: 5
min-idle: 5
max-active: 20
max-wait: 60000
test-while-idle: true
time-between-eviction-runs-millis: 60000
min-evictable-idle-time-millis: 30000
validation-query: select 1
test-on-borrow: false
test-on-return: false
pool-prepared-statements: false
max-pool-prepared-statement-per-connection-size: -1
use-global-data-source-stat: true
servlet:
multipart:
max-file-size: 30MB
max-request-size: 30MB
enabled: true


mybatis-plus:
configuration:
map-underscore-to-camel-case: true
cache-enabled: false
log-impl: org.apache.ibatis.logging.slf4j.Slf4jImpl
global-config:
db-config:
table-prefix: t_
schema: public
logic-delete-field: deleted_at
logic-delete-value: 'now()'
logic-not-delete-value: 'null'
type-aliases-package: com.vainglory.pojo


debug: true




<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>3.4.2</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
<groupId>com.jellyfish</groupId>
<artifactId>vainglory</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>v-vainglory</name>
<description>vainglory is a base project for Jellyfish Ltd</description>

  <properties>
    <java.version>17</java.version>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
  </properties>

  <dependencies>

    <!-- 映射对象 -->
    <dependency>
      <groupId>org.modelmapper</groupId>
      <artifactId>modelmapper</artifactId>
      <version>3.2.2</version>
    </dependency>


    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter</artifactId>
      <version>3.0.4</version>
    </dependency>

    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-spring-boot3-starter</artifactId>
      <version>3.5.10.1</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-jsqlparser -->
    <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-jsqlparser</artifactId>
      <version>3.5.10.1</version>
    </dependency>


    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <scope>runtime</scope>
    </dependency>

    <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <optional>true</optional>
    </dependency>

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-test</artifactId>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>org.mybatis.spring.boot</groupId>
      <artifactId>mybatis-spring-boot-starter-test</artifactId>
      <version>3.0.4</version>
      <scope>test</scope>
    </dependency>



    <!--    druid-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid-spring-boot-3-starter</artifactId>
      <version>1.2.24</version>
    </dependency>

    <!-- Json命名驼峰解析RequestBody -->
    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.18.2</version>
    </dependency>

  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <annotationProcessorPaths>
            <path>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
            </path>
          </annotationProcessorPaths>
        </configuration>
      </plugin>

      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
        <configuration>
          <excludes>
            <exclude>
              <groupId>org.projectlombok</groupId>
              <artifactId>lombok</artifactId>
            </exclude>
          </excludes>
        </configuration>
      </plugin>
    </plugins>
  </build>

</project>



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

