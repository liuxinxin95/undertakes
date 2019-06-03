package com.example.undertakes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.undertakes.dao.SysPermissionRoleDao;
import com.example.undertakes.entity.SysPermissionRole;
import com.example.undertakes.service.SysPermissionRoleService;


@Service("sysPermissionRoleService")
public class SysPermissionRoleServiceImpl implements SysPermissionRoleService {
    @Autowired
    private SysPermissionRoleDao sysPermissionRoleDao;

    @Override
    public SysPermissionRole queryObject(Long id) {
        return sysPermissionRoleDao.queryObject(id);
    }

    @Override
    public List<SysPermissionRole> queryList(Map<String, Object> map) {
        return sysPermissionRoleDao.queryList(map);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysPermissionRole sysPermissionRole) throws Exception{
            sysPermissionRoleDao.save(sysPermissionRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysPermissionRole sysPermissionRole) throws Exception{
            sysPermissionRoleDao.update(sysPermissionRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws Exception{
            sysPermissionRoleDao.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[]ids) throws Exception{
            sysPermissionRoleDao.deleteBatch(ids);
    }

}
