package com.example.undertakes.controller;



import com.example.undertakes.common.utils.DateUtil;
import com.example.undertakes.service.SysGeneratorService;
import com.example.undertakes.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.MapUtils;
import  org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author ChunLiang Hu
 * @Company
 * @Project renren-fast
 * @Package com.distribution.modules.sys.controller
 * @Description TODO(描述)
 * @create 2017/8/13-21:24
 */
@Api("代码生成")
@RestController
@RequestMapping("sys/generator")
public class SysGeneratorController {

    private static Logger log=LoggerFactory.getLogger(SysGeneratorController.class);

    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表数据
     *
     * @param params
     * @return
     */
    @ApiOperation("数据库列表")
    @PostMapping("/list")
    public Result list(@RequestBody Map<String, Object> params) {

        PageInfo<Map<String, Object>> pageInfo;
        try {
//            pageInfo = PageHelper.startPage(MapUtils.getInteger(params, "page", 0),
//                    MapUtils.getInteger(params, "limit", 0)).doSelectPageInfo(() -> sysGeneratorService.queryList(params));

        } catch (Exception e) {
            log.error("查询异常", e);
            return Result.error("查询异常");
        }
//        return Result.ok().put("page", pageInfo);
        return Result.ok().put("list",sysGeneratorService.queryList(params));
    }

    /**
     * 生成代码
     */
    @ApiOperation("生成代码")
    @RequestMapping(value = "/code" ,method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    @ResponseBody
    public Result code(HttpServletRequest request, @RequestBody Map<String, Object> params) throws IOException {
        List<String> tables= (List<String>) params.get("tables");
        byte[] data;
        try {
            data = sysGeneratorService.generatorCode(tables);
        } catch (Exception e) {
            log.error("生成异常", e);
            return Result.error("生成失败");
        }
        String fileName = "gender" + DateUtil.formatDateTime(LocalDateTime.now(), "yyyyMMddHHMMss") + ".zip";
        File file = new File("F:/code/" + fileName);
        try {
            FileUtils.writeByteArrayToFile(file, data);
        } catch (IOException e) {
            log.error("文件写入异常", e);
            return Result.error("生成失败,文件写入异常");
        }
        return Result.ok();
    }
}
