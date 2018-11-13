package com.example.undertakes.controller;

import com.example.undertakes.entity.SysUser;
import com.example.undertakes.service.SysUserService;
import com.example.undertakes.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ????
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-13
 */
@RestController
@RequestMapping("sysuser")
public class SysUserController {

    private static Logger log = LoggerFactory.getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Result list(@RequestBody Map<String, Object> params) {
        //查询列表数据
        PageInfo<SysUser> pageInfo = PageHelper.startPage(MapUtils.getInteger(params, "page"),
                MapUtils.getInteger(params, "limit")).doSelectPageInfo(() -> sysUserService.queryList(params));
        return Result.ok().put("page", pageInfo);
    }


    /**
     * 信息
     */
    @RequestMapping(value = "/info/{userId}",method = RequestMethod.GET)
    public Result info(@PathVariable("userId") Long userId) {
            SysUser sysUser = sysUserService.queryObject(userId);

        return Result.ok().put("sysUser", sysUser);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody SysUser sysUser) {
        try {
                sysUserService.save(sysUser);
        } catch (Exception e) {
            log.error("保存异常", e);
            return Result.error("保存异常");
        }

        return Result.ok();
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public Result update(@RequestBody SysUser sysUser) {
        try {
                sysUserService.update(sysUser);
        } catch (Exception e) {
            log.error("修改异常", e);
            return Result.error("修改异常");
        }
        return Result.ok();
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete" ,method = RequestMethod.DELETE)
    public Result delete(@RequestBody Long[]userIds) {
        try {
            if (userIds.length == 1) {
                    sysUserService.delete(userIds[0]);
            } else {
                    sysUserService.deleteBatch(userIds);
            }
        } catch (Exception e) {
            log.error("删除异常", e);
            return Result.error("删除异常");
        }
        return Result.ok();
    }

}
