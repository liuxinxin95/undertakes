package com.example.undertakes.service.impl;

import com.example.undertakes.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.example.undertakes.dao.SysUserDao;
import com.example.undertakes.service.SysUserService;
import org.springframework.transaction.annotation.Transactional;


@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser queryObject(Long userId) {
        return sysUserDao.queryObject(userId);
    }

    @Override
    public List<SysUser> queryList(Map<String, Object> map) {
        return sysUserDao.queryList(map);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUser SysUser) throws Exception{
            sysUserDao.save(SysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUser SysUser) throws Exception{
            sysUserDao.update(SysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long userId) throws Exception{
            sysUserDao.delete(userId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Long[]userIds) throws Exception{
            sysUserDao.deleteBatch(userIds);
    }

}
