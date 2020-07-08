package com.springboot.commons.myBatis;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * 插入单表批量插入，非自增自定义ID场景使用
 */
public class InsertBatchProvider extends MapperTemplate {

    public InsertBatchProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 批量插入所有字段
     * @param ms
     * @return
     */
    public String insertBatch(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.insertIntoTable(entityClass, tableName(entityClass)));
        sql.append(SqlHelper.insertColumns(entityClass, false, false, false));
        sql.append(" VALUES ");
        sql.append("<foreach collection=\"list\" item=\"record\" separator=\",\" >");
        sql.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        for (EntityColumn column : columnList) {
            if (column.isInsertable()) {
                sql.append(column.getColumnHolder("record") + ",");
            }
        }
        sql.append("</trim>");
        sql.append("</foreach>");
        return sql.toString();
    }

    public String updateBatch(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sqlSB = new StringBuilder();
        sqlSB.append("<foreach collection=\"list\" item=\"record\" open=\"\" close=\"\" separator=\";\" >");

        sqlSB.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        String updateSetColumnsStr = SqlHelper.updateSetColumns(entityClass, "record", true, false);
        sqlSB.append(updateSetColumnsStr);
        sqlSB.append(MySqlHelper.wherePKColumns(entityClass,"record",false));

        sqlSB.append("</foreach>");
        String sql = sqlSB.toString();
        sql = sql.replaceAll("#\\{record.record.", "#{record.");

        System.out.println("sql="+sql);
        return sql;
    }



}
