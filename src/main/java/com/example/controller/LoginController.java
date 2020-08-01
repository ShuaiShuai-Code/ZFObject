package com.example.controller;

import com.example.common.resp.BaseResp;
import com.example.model.zf_user;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class LoginController {

    @Resource
    JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public BaseResp login(String id) {
        if (StringUtils.isEmpty(id)) {
            return new BaseResp(400, "参数错误");
        }
        String sql = "SELECT * from zf_user WHERE user_id= ?";
        List<zf_user> user = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper(zf_user.class));
        if (null == user || user.size() == 0) {
            return new BaseResp(400, "无数据");
        }
        return new BaseResp(200, "success", user.get(0));
    }
}
