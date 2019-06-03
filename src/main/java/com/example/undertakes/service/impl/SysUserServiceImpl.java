package com.example.undertakes.service.impl;

import com.example.undertakes.entity.SysUser;
import com.example.undertakes.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.example.undertakes.dao.SysUserDao;
import com.example.undertakes.service.SysUserService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * @author lxx
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRepository sysUserRepository;

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
    public void save(SysUser sysUser) throws Exception{
            sysUserDao.save(sysUser);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysUser sysUser) throws Exception{
            sysUserDao.update(sysUser);
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SysUser loadUserByUsername(String username) {
        SysUser user = sysUserRepository.findByUsername(username);
//        if (user == null) {
//            throw new RRException("用户名不存在");
//        }
//        String pwd = new BCryptPasswordEncoder().encode(user.getPassword());
//        user.setPassword(pwd);
        return user;
    }

    @Override
    public SysUser isValidPassword(SysUser sysUser){
        Example<SysUser> example = Example.of(sysUser);
        SysUser one = sysUserRepository.findOne(example);
        return one;
    }


}
