package com.example.undertakes.repository;
import com.example.undertakes.entity.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * 权限表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
public interface SysPermissionRepository  extends JpaRepository<SysPermission,Long>,JpaSpecificationExecutor<SysPermission> {
}