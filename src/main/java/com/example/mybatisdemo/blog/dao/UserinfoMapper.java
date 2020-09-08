package com.example.mybatisdemo.blog.dao;

import com.example.mybatisdemo.blog.VO.Userinfo;
import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    List<Userinfo> selectAll();

    int updateByPrimaryKey(Userinfo record);
}