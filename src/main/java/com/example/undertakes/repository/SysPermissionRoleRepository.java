package com.example.undertakes.repository;
import com.example.undertakes.entity.SysPermissionRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * 权限角色关联表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
public interface SysPermissionRoleRepository  extends JpaRepository<SysPermissionRole,Long>,JpaSpecificationExecutor<SysPermissionRole> {

}