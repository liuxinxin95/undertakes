package com.example.undertakes.repository;

import com.example.undertakes.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
/**
 * ????
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-13
 */
public interface SysUserRepository  extends JpaRepository<SysUser,Long>,JpaSpecificationExecutor<SysUser> {

}