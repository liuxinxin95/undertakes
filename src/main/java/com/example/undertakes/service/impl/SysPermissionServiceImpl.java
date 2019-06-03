package com.example.undertakes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.undertakes.dao.SysPermissionDao;
import com.example.undertakes.entity.SysPermission;
import com.example.undertakes.service.SysPermissionService;


@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public SysPermission queryObject(Long id) {
        return sysPermissionDao.queryObject(id);
    }

    @Override
    public List<SysPermission> queryList(Map<String, Object> map) {
        return sysPermissionDao.queryList(map);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysPermission sysPermission) throws Exception{
            sysPermissionDao.save(sysPermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysPermission sysPermission) throws Exception{
            sysPermissionDao.update(sysPermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws Exception{
            sysPermissionDao.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[]ids) throws Exception{
            sysPermissionDao.deleteBatch(ids);
    }

}
