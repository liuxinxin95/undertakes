package com.example.undertakes.repository;
import com.example.undertakes.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * 角色
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
public interface SysRoleRepository  extends JpaRepository<SysRole,Long>,JpaSpecificationExecutor<SysRole> {

}