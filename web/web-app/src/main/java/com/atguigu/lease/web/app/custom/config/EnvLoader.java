package com.atguigu.lease.web.app.custom.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.nio.file.Paths;

public class EnvLoader {


    public static void loadEnv() {
        // 指定 .env 文件所在路径
        String envPath = Paths.get("web/web-app/src/main/resources").toAbsolutePath().toString();
        System.out.println("Loading .env from: " + envPath);
        String env = Paths.get("web/web-app/src/main/resources/.env").toAbsolutePath().toString();
        System.out.println("Loading .env: " + env);

        // 加载 .env 文件
        Dotenv dotenv = Dotenv.configure()
                .directory(envPath)
                .filename(".env")
                .load();


        String dbUsername = dotenv.get("DB_USERNAME");
        String dbPassword = dotenv.get("DB_PASSWORD");
//        String aliyunSmsAccessKeyId = dotenv.get("ALIYUN_SMS_ACCESS_KEY_ID");
//        String aliyunSmsAccessKeySecret = dotenv.get("ALIYUN_SMS_ACCESS_KEY_SECRET");
//        String aliyunSmsEndpoint = dotenv.get("ALIYUN_SMS_ENDPOINT");

        if (dbUsername != null) {
            System.setProperty("DB_USERNAME", dbUsername);
        }
        if (dbPassword != null) {
            System.setProperty("DB_PASSWORD", dbPassword);
        }
//        if (aliyunSmsAccessKeyId != null) {
//            System.setProperty("ALIYUN_SMS_ACCESS_KEY_ID", aliyunSmsAccessKeyId);
//        }
//        if (aliyunSmsAccessKeySecret != null) {
//            System.setProperty("ALIYUN_SMS_ACCESS_KEY_SECRET", aliyunSmsAccessKeySecret);
//        }
//        if (aliyunSmsEndpoint != null) {
//            System.setProperty("ALIYUN_SMS_ENDPOINT", aliyunSmsEndpoint);
//        }

        // Output testing
        System.out.println("DB_USERNAME: " + dbUsername);
        System.out.println("DB_PASSWORD: " + dbPassword);
//        System.out.println("ALIYUN_SMS_ACCESS_KEY_ID: " + aliyunSmsAccessKeyId);
//        System.out.println("ALIYUN_SMS_ACCESS_KEY_SECRET: " + aliyunSmsAccessKeySecret);
//        System.out.println("ALIYUN_SMS_ENDPOINT: " + aliyunSmsEndpoint);
    }

}

