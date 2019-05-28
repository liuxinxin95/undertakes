package com.example.undertakes.dao;

import com.example.undertakes.entity.BlobField;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlobFielddDao {

    void insert(BlobField blobField);
    List<BlobField> findList();

}
