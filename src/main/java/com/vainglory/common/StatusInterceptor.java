package com.vainglory.common;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.plugins.InterceptorIgnoreHelper;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.parser.JsqlParserSupport;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.HexValue;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.WithItem;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/*
参考:
 https://juejin.cn/post/7267092779293261860
 */


@Intercepts({
    @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})

public class StatusInterceptor extends JsqlParserSupport implements InnerInterceptor {


  public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds,
                          ResultHandler resultHandler, BoundSql boundSql) {

    if (InterceptorIgnoreHelper.willIgnoreDataPermission(ms.getId())) {
      return;
    }

    // 通过检查StatusConditionHelper的状态，如果不需要跳过
    if (!StatusConditionHelper.isSkipStatusCondition()) {

      PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);

      // 处理sql
      mpBs.sql(parserSingle(mpBs.sql(), ms.getId()));

      // 获取SQL语句
//      String sql = boundSql.getSql().trim();
//      // 检查是否是SELECT查询
//      if (ms.getSqlCommandType() == SqlCommandType.SELECT) {
//        // 获取SQL语句的元对象
//        MetaObject metaObject = SystemMetaObject.forObject(boundSql);
//        // 构建新的SQL语句，添加status=1的过滤条件
//        String newSql = sql + " AND status=1";
//        // 设置新的SQL语句
//        metaObject.setValue("sql", newSql);
//      }
    }
  }


  @Override
  protected void processSelect(Select select, int index, String sql, Object obj) {
    if (select instanceof PlainSelect) {
      setWhere((PlainSelect) select, "status");
    } else if (select instanceof SetOperationList) {
      SetOperationList setOperationList = (SetOperationList) select;
      List<Select> selects = setOperationList.getSelects();
      for (Select s : selects) {
        setWhere((PlainSelect) s, "status");
      }
    }
  }

  private void setWhere(PlainSelect select, String segment) {
    Expression sqlExpression = getSqlExpression(select, segment);
    select.setWhere(sqlExpression);
  }

  private Expression getSqlExpression(PlainSelect select, String segment) {
    EqualsTo equalsTo = new EqualsTo(new Column(segment), new LongValue(Constants.STATUS_ENABLE));
    Expression where = select.getWhere();
    if (where == null) {
      return equalsTo;
    }

    AndExpression andExpression = new AndExpression();
    andExpression.setLeftExpression(where);
    andExpression.setRightExpression(equalsTo);
    return andExpression;
  }

}