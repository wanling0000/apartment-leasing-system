package com.atguigu.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.atguigu.lease") //这里记得改
public class MybatisPlusConfiguration {
  
}