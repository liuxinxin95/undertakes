package com.example.undertakes.service;

import com.example.undertakes.entity.SysUser;

import java.util.List;
import java.util.Map;


/**
 * ????
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-13
 */
public interface SysUserService {
    /**
    * 根据ID查询
    * @return
    */
     SysUser queryObject(Long userId);

    /**
    * 查询列表
    * @param map
    * @return
    */
    List<SysUser> queryList(Map<String, Object> map);

    /**
    * 保存
    * @throws Exception
    */
    void save(SysUser SysUser) throws Exception;

    /**
    * 更新
    * @throws Exception
    */
    void update(SysUser SysUser) throws Exception;

    /**
    * 删除
    * @throws Exception
    */
    void delete(Long userId) throws Exception;

    /**
    * 批量删除
    * @throws Exception
    */
    void deleteBatch(Long[] userIds) throws Exception;
}
