package com.example.undertakes.service;
import com.example.undertakes.entity.SysRole;
import java.util.List;
import java.util.Map;


/**
 * 角色
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
public interface SysRoleService {
    /**
    * 根据ID查询
    * @return
    */
     SysRole queryObject(Long id);

    /**
    * 查询列表
    * @param map
    * @return
    */
    List<SysRole> queryList(Map<String, Object> map);

    /**
    * 保存
    * @throws Exception
    */
    void save(SysRole SysRole) throws Exception;

    /**
    * 更新
    * @throws Exception
    */
    void update(SysRole SysRole) throws Exception;

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
