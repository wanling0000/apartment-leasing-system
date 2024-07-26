package com.atguigu.lease.web.admin.controller.test;

import com.atguigu.lease.web.admin.mapper.UserInfoMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.atguigu.lease.model.entity.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 之前数据库连接不成功写的测试类
 */
@RestController
public class TestController {

    @Resource
    private UserInfoMapper userInfoMapper;

    @GetMapping("/test-db")
    public String testDbConnection() {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.last("LIMIT 1");
        UserInfo user = userInfoMapper.selectOne(queryWrapper);
        return user != null ? "Database connection is successful" : "Database connection failed";
    }
}
