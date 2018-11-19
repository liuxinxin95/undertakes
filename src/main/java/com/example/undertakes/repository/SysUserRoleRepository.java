package com.example.undertakes.repository;
import com.example.undertakes.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * 用户角色表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
public interface SysUserRoleRepository  extends JpaRepository<SysUserRole,Long>,JpaSpecificationExecutor<SysUserRole> {

}