package com.vainglory.common.mybatis.interceptor;

import com.baomidou.mybatisplus.core.plugins.InterceptorIgnoreHelper;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.parser.JsqlParserSupport;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.vainglory.common.core.enums.Status;
import com.vainglory.common.mybatis.utils.StatusConditionUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SetOperationList;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.List;

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

    // 不需要进行状态处理
    if (StatusConditionUtils.isSkipStatusCondition()) {
      return;
    }

    // 处理sql
    PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
    mpBs.sql(parserSingle(mpBs.sql(), ms.getId()));
  }


  @Override
  protected void processSelect(Select select, int index, String sql, Object obj) {
    String mappedStatementId = String.valueOf(obj);
    if (select instanceof PlainSelect) {
      setWhere((PlainSelect) select, mappedStatementId);
    } else if (select instanceof SetOperationList setOperationList) {
      List<Select> selects = setOperationList.getSelects();
      for (Select s : selects) {
        setWhere((PlainSelect) s, mappedStatementId);
      }
    }
  }

  private void setWhere(PlainSelect select, String mappedStatementId) {
    Expression sqlExpression = getSqlExpression(select, mappedStatementId);
    select.setWhere(sqlExpression);
  }


  private Expression getSqlExpression(PlainSelect select, String mappedStatementId) {
    EqualsTo equalsTo = new EqualsTo(new Column("status"), new LongValue(Status.ENABLE.getCode()));
    Expression where = select.getWhere();
    if (where == null) {
      return equalsTo;
    }
    AndExpression andExpression = new AndExpression();
    andExpression.setLeftExpression(where);
    andExpression.setRightExpression(equalsTo);
    return andExpression;
  }


  /*
   * 依据注解的版本,暂时没有调通, 详情见自定义statusNodeControl注解那里.
   */
//  private Expression getSqlExpression(PlainSelect select, String mappedStatementId) {
//    String className = mappedStatementId.substring(0, mappedStatementId.lastIndexOf("."));
//    String methodName = mappedStatementId.substring(mappedStatementId.lastIndexOf(".") + 1);
//    try {
//      Method[] methods = Class.forName(className).getMethods();
//      for (Method method : methods) {
//        if (method.getName().equals(methodName)) {
//          StatusNoneControl annotation = method.getAnnotation(StatusNoneControl.class);
//          if (annotation != null) {
//            // 如果找到注解，说明用户显示的要求不需要控制状态
//            return select.getWhere();
//          } else {
//            /*
//             如果方法名找到，但没有注解，说明是要控制状态的
//             既然知道了结果, 那跳出逻辑即可.
//             TODO:
//             这里可以优化性能逻辑,上述的查询的结果,其实可以放在一个map中,
//             key是mappedStatementId, value是是否需要status注解
//             这样,会大大增加查询速度.
//             */
//            break;
//          }
//        }
//      }
//    } catch (ClassNotFoundException e) {
//      throw new RuntimeException(e);
//    }
//    // 这里是需要控制状态的
//    EqualsTo equalsTo = new EqualsTo(new Column("status"), new LongValue(Constants.STATUS_ENABLE));
//    Expression where = select.getWhere();
//    if (where == null) {
//      return equalsTo;
//    }
//    AndExpression andExpression = new AndExpression();
//    andExpression.setLeftExpression(where);
//    andExpression.setRightExpression(equalsTo);
//    return andExpression;
//  }
}