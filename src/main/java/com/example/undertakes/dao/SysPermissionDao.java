package com.example.undertakes.dao;

import com.example.undertakes.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 权限表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
@Mapper
public interface SysPermissionDao extends BaseDao<SysPermission> {
    public List<SysPermission> findAll();
    public List<SysPermission> findByAdminUserId(Long userId);
}
