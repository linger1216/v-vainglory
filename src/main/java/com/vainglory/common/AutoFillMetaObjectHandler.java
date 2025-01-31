package com.vainglory.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Component
public class AutoFillMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {


//    // 创建时间和更新时间都插入
//    Object created = getFieldValByName("createTime", metaObject);
//    if (null == created) {
//      setFieldValByName("createTime", LocalDateTime.now(), metaObject);
//    }
//
//    Object updated = getFieldValByName("updateTime", metaObject);
//    if (null == updated) {
//      setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
//    }


    this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());

    Object status = getFieldValByName("status", metaObject);
    if (null == status) {
      this.strictInsertFill(metaObject, "status", Integer.class, Constants.STATUS_ENABLE);
    }

//    this.strictInsertFill(metaObject, "createBy", String.class, jwtTokenUtil.getUsernameFromToken());
//    this.strictUpdateFill(metaObject, "updateBy", String.class, jwtTokenUtil.getUsernameFromToken());
  }

  @Override
  public void updateFill(MetaObject metaObject) {

//    this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);

    this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
//    this.strictUpdateFill(metaObject, "updateBy", String.class, jwtTokenUtil.getUsernameFromToken());
  }

  private Date convertToDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }
}
