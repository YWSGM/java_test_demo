package com.example.mybatisdemo.blog.controller;

import com.example.mybatisdemo.blog.VO.Userinfo;
import com.example.mybatisdemo.blog.dao.UserinfoMapper;
import com.example.mybatisdemo.blog.serves.JsonResult;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping(value = "/list")
    @ResponseBody
    public JsonResult<List> Userinfo() {
        String sql = "select * from UserInfo";
        List<Map<String, Object>> list = new ArrayList<>();
        list = jdbcTemplate.queryForList(sql);
        return new JsonResult<>(list);
    }

    /*@PostMapping(value = "/insert")
    @ResponseBody
    public JsonResult<Object> InsertUsers(
            @RequestParam(value = "userName") String userName,
            @RequestParam(value = "age") String age,
            @RequestParam(value = "passWord") String passWord,
            @RequestParam(value = "sex") String sex
    ) {
        String sql = "insert into `userInfo` (`userName`,`age`,passWord,`sex`) value(?,?,?,?) ";
        if (sex.equals("0")) {
            sex = "男";
        } else {
            sex = "女";
        }
        jdbcTemplate.update(sql, userName, age, passWord, sex);
        return new JsonResult<>("0", "插入成功");
    }*/

    @PostMapping(value = "/insert")
    @ResponseBody
    public JsonResult<Object> InsertUsers(@RequestBody Userinfo user) {
        String sql = "insert into `userInfo` (`userName`,`age`,passWord,`sex`) value(?,?,?,?) ";
        String sex = "";
        if (user.getSex().equals("0")) {
            sex = "男";
        } else {
            sex = "女";
        }
        jdbcTemplate.update(sql, user.getUsername(), user.getAge(), user.getPassword(), sex);
        return new JsonResult<>("0", "插入成功");
    }
}
