package com.example.undertakes.entity;


import java.util.List;

/**
 * @author ChunLiang Hu
 * @Company
 * @Project renren-fast
 * @Package com.distribution.modules.sys.entity
 * @Description 表数据
 * @create 2017/8/13-21:04
 */

public class TableEntity {
    /**
     * 表的名称
     */
    private String tableName;
    /**
     * 表的备注
     */
    private String comments;
    /**
     * 表的主键
     */
    private ColumnEntity pk;
    /**
     * 表的列名(不包含主键)
     */
    private List<ColumnEntity> columns;

    /**
     * 类名(第一个字母大写)，如：sys_user => SysUser
     */
    private String upClassName;
    /**
     * 类名(第一个字母小写)，如：sys_user => sysUser
     */
    private String lowClassName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ColumnEntity getPk() {
        return pk;
    }

    public void setPk(ColumnEntity pk) {
        this.pk = pk;
    }

    public List<ColumnEntity> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnEntity> columns) {
        this.columns = columns;
    }

    public String getUpClassName() {
        return upClassName;
    }

    public void setUpClassName(String upClassName) {
        this.upClassName = upClassName;
    }

    public String getLowClassName() {
        return lowClassName;
    }

    public void setLowClassName(String lowClassName) {
        this.lowClassName = lowClassName;
    }
}
