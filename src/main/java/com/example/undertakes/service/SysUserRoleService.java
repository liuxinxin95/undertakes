package com.example.undertakes.service;
import com.example.undertakes.entity.SysUserRole;
import java.util.List;
import java.util.Map;


/**
 * 用户角色表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
public interface SysUserRoleService {
    /**
    * 根据ID查询
    * @return
    */
     SysUserRole queryObject(Long id);

    /**
    * 查询列表
    * @param map
    * @return
    */
    List<SysUserRole> queryList(Map<String, Object> map);

    /**
    * 保存
    * @throws Exception
    */
    void save(SysUserRole sysUserRole) throws Exception;

    /**
    * 更新
    * @throws Exception
    */
    void update(SysUserRole sysUserRole) throws Exception;

    /**
    * 删除
    * @throws Exception
    */
    void delete(Long id) throws Exception;

    /**
    * 批量删除
    * @throws Exception
    */
    void deleteBatch(Long[] ids) throws Exception;
}
