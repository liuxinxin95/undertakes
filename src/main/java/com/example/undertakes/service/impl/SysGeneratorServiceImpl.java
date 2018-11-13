package com.example.undertakes.service.impl;
import com.example.undertakes.dao.SysGeneratorDao;
import com.example.undertakes.service.SysGeneratorService;
import com.example.undertakes.util.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 代码生成器
 *
 * @author ChunLiang Hu
 * @email davichi2009@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@Service
public class SysGeneratorServiceImpl implements SysGeneratorService {
    @Autowired
    private SysGeneratorDao sysGeneratorDao;

    @Override
    public List<Map<String, Object>> queryList(Map<String, Object> map) {
        return sysGeneratorDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return sysGeneratorDao.queryTotal(map);
    }

    @Override
    public Map<String, String> queryTable(String tableName) {
        return sysGeneratorDao.queryTable(tableName);
    }

    @Override
    public List<Map<String, String>> queryColumns(String tableName) {
        return sysGeneratorDao.queryColumns(tableName);
    }

    @Override
    public byte[] generatorCode(List<String> tableNames) {
        try {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); ZipOutputStream zip = new ZipOutputStream(outputStream)) {
                tableNames.forEach(tableName -> {
                    //查询表信息
                    Map<String, String> table = queryTable(tableName);
                    //查询列信息
                    List<Map<String, String>> columns = queryColumns(tableName);
                    //生成代码
                    GenUtils.generatorCode(table, columns, zip);
                });
                IOUtils.closeQuietly(zip);
                return outputStream.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
