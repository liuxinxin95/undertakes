package com.example.undertakes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.undertakes.dao.SysUserRoleDao;
import com.example.undertakes.entity.SysUserRole;
import com.example.undertakes.service.SysUserRoleService;


@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public SysUserRole queryObject(Long id) {
        return sysUserRoleDao.queryObject(id);
    }

    @Override
    public List<SysUserRole> queryList(Map<String, Object> map) {
        return sysUserRoleDao.queryList(map);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserRole SysUserRole) throws Exception{
            sysUserRoleDao.save(SysUserRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUserRole SysUserRole) throws Exception{
            sysUserRoleDao.update(SysUserRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws Exception{
            sysUserRoleDao.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[]ids) throws Exception{
            sysUserRoleDao.deleteBatch(ids);
    }

}
