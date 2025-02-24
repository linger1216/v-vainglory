package com.vainglory.handler.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


/*
mybatis plus
插入数据库的时候，自动填充数据
 */

public class InjectMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    Date date = new Date();
    this.strictInsertFill(metaObject, "createTime", Date.class, date);
    this.strictInsertFill(metaObject, "updateTime", Date.class, date);

//    Object status = getFieldValByName("status", metaObject);
//    if (null == status) {
//      this.strictInsertFill(metaObject, "status", Integer.class, Status.ENABLE.getCode());
//    }
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
  }
}
