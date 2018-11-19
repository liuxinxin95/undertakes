package com.example.undertakes.controller;

import com.example.undertakes.entity.SysPermissionRole;
import com.example.undertakes.service.SysPermissionRoleService;
import com.example.undertakes.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 权限角色关联表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
@Api("权限角色关联表")
@RestController
@RequestMapping("syspermissionrole")
public class SysPermissionRoleController {

    private static Logger log = LoggerFactory.getLogger(SysPermissionRoleController.class);

    @Autowired
    private SysPermissionRoleService sysPermissionRoleService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Result list(@RequestBody Map<String, Object> params) {
        //查询列表数据
        PageInfo<SysPermissionRole> pageInfo = PageHelper.startPage(MapUtils.getInteger(params, "page"),
                MapUtils.getInteger(params, "limit")).doSelectPageInfo(() -> sysPermissionRoleService.queryList(params));
        return Result.ok().put("page", pageInfo);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public Result info(@PathVariable("id") Long id) {
            SysPermissionRole sysPermissionRole = sysPermissionRoleService.queryObject(id);

        return Result.ok().put("sysPermissionRole", sysPermissionRole);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody SysPermissionRole sysPermissionRole) {
        try {
                sysPermissionRoleService.save(sysPermissionRole);
        } catch (Exception e) {
            log.error("保存异常", e);
            return Result.error("保存异常");
        }

        return Result.ok();
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public Result update(@RequestBody SysPermissionRole sysPermissionRole) {
        try {
                sysPermissionRoleService.update(sysPermissionRole);
        } catch (Exception e) {
            log.error("修改异常", e);
            return Result.error("修改异常");
        }
        return Result.ok();
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @RequestMapping(value = "/delete" ,method = RequestMethod.DELETE)
    public Result delete(@RequestBody Long[]ids) {
        try {
            if (ids.length == 1) {
                    sysPermissionRoleService.delete(ids[0]);
            } else {
                    sysPermissionRoleService.deleteBatch(ids);
            }
        } catch (Exception e) {
            log.error("删除异常", e);
            return Result.error("删除异常");
        }
        return Result.ok();
    }

}
