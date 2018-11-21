package com.example.undertakes.controller;

import com.example.undertakes.config.JwtAuthenticationFilter;
import com.example.undertakes.entity.SysUser;
import com.example.undertakes.exception.RRException;
import com.example.undertakes.service.SysUserService;
import com.example.undertakes.util.JwtUtil;
import com.example.undertakes.util.MD5;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@RestController
@RequestMapping(value="/login")
public class loginController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value="/check", method=RequestMethod.POST)
    @ApiOperation(value="登入身份验证（JWT验证）", notes="登入")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username",value = "用户名称",required = true,paramType = "query",dataType = "string"),
        @ApiImplicitParam(name = "password",value = "密码",required = true,paramType = "query",dataType = "string")
    })
    public Object getLoginInfo(String username, String password) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        if(isValidPassword(sysUser)) {
            String jwt = JwtUtil.generateToken(sysUser.getUsername());
            return new HashMap<String,String>(){{
                put("token", jwt);
            }};
        }else {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

//    @Bean
//    public FilterRegistrationBean jwtFilter() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
//        registrationBean.setFilter(filter);
//        return registrationBean;
//    }

    //密码是否正确
    private boolean isValidPassword(SysUser sysUser) {
        SysUser sysUser1 = sysUserService.loadUserByUsername(sysUser.getUsername());
        if (sysUser1==null){
            throw new RRException("用户名不存在,请先注册");
        }
        if (!sysUser1.getPassword().equals(MD5.encodeByMd5AndSalt(sysUser.getPassword()))){
            throw new RRException("用户名或者密码不正确，请重新输入");
        }
        return true;
    }
}