package com.atguigu.lease.web.app.service.impl;

import com.atguigu.lease.web.app.service.SmsService;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

@SpringBootTest
class SmsServiceImplTest {
    @Autowired
    private SmsService service;
//
//    @BeforeEach
//    void setup() {
//        // 设置 .env 文件的绝对路径
//        String envFilePath = "/Users/fwl/coding/ideaJavaProj/web-pro/lease/lease/web/web-app/src/main/resources/.env";
//
//        // 加载 .env 文件
//        Dotenv dotenv = Dotenv.configure()
//                .directory(Paths.get(envFilePath).getParent().toString())
//                .filename(Paths.get(envFilePath).getFileName().toString())
//                .load();
//
//        // 从 .env 文件中获取环境变量
//
//        String aliyunSmsAccessKeyId = dotenv.get("ALIYUN_SMS_ACCESS_KEY_ID");
//        String aliyunSmsAccessKeySecret = dotenv.get("ALIYUN_SMS_ACCESS_KEY_SECRET");
//        String aliyunSmsEndpoint = dotenv.get("ALIYUN_SMS_ENDPOINT");
//
//        // 检查是否有 null 值并设置系统属性
//        if (aliyunSmsAccessKeyId != null) {
//            System.setProperty("ALIYUN_SMS_ACCESS_KEY_ID", aliyunSmsAccessKeyId);
//        }
//        if (aliyunSmsAccessKeySecret != null) {
//            System.setProperty("ALIYUN_SMS_ACCESS_KEY_SECRET", aliyunSmsAccessKeySecret);
//        }
//        if (aliyunSmsEndpoint != null) {
//            System.setProperty("ALIYUN_SMS_ENDPOINT", aliyunSmsEndpoint);
//        }
//        System.out.println("ALIYUN_SMS_ACCESS_KEY_ID: " + aliyunSmsAccessKeyId);
//        System.out.println("ALIYUN_SMS_ACCESS_KEY_SECRET: " + aliyunSmsAccessKeySecret);
//        System.out.println("ALIYUN_SMS_ENDPOINT: " + aliyunSmsEndpoint);
//    }

    @Test
    void sendCode() {
        service.sendCode("18908115549", "1234");
    }
}