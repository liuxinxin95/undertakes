package com.example.undertakes.controller;

import com.example.undertakes.entity.SysPermission;
import com.example.undertakes.service.SysPermissionService;
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
 * 权限表
 *
 * @author liuxinxin
 * @email 18634318474@163.com
 * @date 2018-11-19
 */
@Api("权限表")
@RestController
@RequestMapping("syspermission")
public class SysPermissionController {

    private static Logger log = LoggerFactory.getLogger(SysPermissionController.class);


    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 列表
     */
    @ApiOperation("列表")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Result list(@RequestBody Map<String, Object> params) {
        //查询列表数据
        PageInfo<SysPermission> pageInfo = PageHelper.startPage(MapUtils.getInteger(params, "page"),
                MapUtils.getInteger(params, "limit")).doSelectPageInfo(() -> sysPermissionService.queryList(params));
        return Result.ok().put("page", pageInfo);
    }


    /**
     * 信息
     */
    @ApiOperation("信息")
    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public Result info(@PathVariable("id") Long id) {
            SysPermission sysPermission = sysPermissionService.queryObject(id);

        return Result.ok().put("sysPermission", sysPermission);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody SysPermission sysPermission) {
        try {
                sysPermissionService.save(sysPermission);
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
    public Result update(@RequestBody SysPermission sysPermission) {
        try {
                sysPermissionService.update(sysPermission);
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
                    sysPermissionService.delete(ids[0]);
            } else {
                    sysPermissionService.deleteBatch(ids);
            }
        } catch (Exception e) {
            log.error("删除异常", e);
            return Result.error("删除异常");
        }
        return Result.ok();
    }

}
