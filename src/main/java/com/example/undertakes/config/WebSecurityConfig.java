package com.example.undertakes.config;
 

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * @author zhaoxinguo on 2017/9/13.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    private UserDetailsService userDetailsService;
 
    private BCryptPasswordEncoder bCryptPasswordEncoder;
 
    public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    // 设置 HTTP 验证规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 关闭csrf验证
        http.cors().and().csrf().disable()
                // 对请求进行认证
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/doc.html").permitAll()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/v2/**").permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                // 添加一个过滤器 所有访问 /login 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
                .addFilter(new JWTLoginFilter(authenticationManager()))
                // 添加一个过滤器验证其他请求的Token是否合法
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
    }
 
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }
 
}
