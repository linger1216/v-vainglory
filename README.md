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

