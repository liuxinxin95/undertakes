package com.example.undertakes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.undertakes.dao.SysRoleDao;
import com.example.undertakes.entity.SysRole;
import com.example.undertakes.service.SysRoleService;


@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public SysRole queryObject(Long id) {
        return sysRoleDao.queryObject(id);
    }

    @Override
    public List<SysRole> queryList(Map<String, Object> map) {
        return sysRoleDao.queryList(map);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysRole SysRole) throws Exception{
            sysRoleDao.save(SysRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRole SysRole) throws Exception{
            sysRoleDao.update(SysRole);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) throws Exception{
            sysRoleDao.delete(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[]ids) throws Exception{
            sysRoleDao.deleteBatch(ids);
    }

}
