package com.example.undertakes.service.impl;

import com.example.undertakes.dao.SysPermissionDao;
import com.example.undertakes.entity.SysPermission;
import com.example.undertakes.entity.SysUser;
import com.example.undertakes.repository.SysPermissionRepository;
import com.example.undertakes.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuxinxin
 * @Description
 * @Date 2018/11/19 16:19
 * @Param 
 * @Return 
*/
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    SysUserRepository sysUserRepository;
    @Autowired
    SysPermissionRepository sysPermissionRepository;
    @Autowired
    SysPermissionDao sysPermissionDao;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = sysUserRepository.findByUsername(username);
        if (user != null) {
            List<SysPermission> permissions = sysPermissionDao.findByAdminUserId(user.getUserId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList <>();
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

}