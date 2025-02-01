package com.vainglory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
  TODO:
  查询全部状态的注解
  因为这个注解是加入到controller中,但因为拦截器mappedStatementId, 是加入到mapper中的,如下:
  com.vainglory.mapper.UserMapper.selectList,所以从这个mappedStatementId
  中并不能识别出是Controller这一层的方法,来找到是否注解, 但怎么传入一个id,让拦截器知道是什么方法呢?
  这个答案还暂时不知道, 而且目前也没有时间研究, 留待以后吧.

  所以目前这个类,暂时不用.
 */

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StatusNoneControl { }
