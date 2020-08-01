package com.example.controller;

import com.example.common.resp.BaseResp;
import com.example.model.zf_order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class IndexController {

    @Resource
    JdbcTemplate jdbcTemplate;

    @GetMapping("/orderList")
    public BaseResp orderList() {
        String sql = "SELECT * from zf_order";
        List<zf_order> orderList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(zf_order.class));
        return new BaseResp(200, "success", orderList);
    }

}
