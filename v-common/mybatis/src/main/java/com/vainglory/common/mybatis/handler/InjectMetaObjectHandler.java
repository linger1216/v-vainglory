package com.vainglory.common.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.vainglory.common.core.enums.Status;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;


/*
TODO:
还缺乏对其他字段进行填充
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
