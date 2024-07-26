//package com.atguigu.lease.web.admin.custom.config;
//
//import io.github.cdimascio.dotenv.Dotenv;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.core.env.ConfigurableEnvironment;
//
//import java.nio.file.Paths;
//
//@Configuration
//public class DotenvConfig {
//    private final ConfigurableEnvironment env;
//
//    public DotenvConfig(ConfigurableEnvironment env) {
//        this.env = env;
//    }
//
//    @EventListener
//    public void handleContextRefresh(ContextRefreshedEvent event) {
//        // 打印当前工作目录，便于调试
//        System.out.println("Current working directory: " + System.getProperty("user.dir"));
//
//        try {
//            // 动态确定 .env 文件路径
//            String envPath = Paths.get(System.getProperty("user.dir"), "src/main/resources").normalize().toString();
//            System.out.println("Loading .env from: " + envPath);
//
//            Dotenv dotenv = Dotenv.configure()
//                    .directory(envPath)
//                    .filename(".env")
//                    .load();
//
//            String dbUsername = dotenv.get("DB_USERNAME");
//            String dbPassword = dotenv.get("DB_PASSWORD");
//
//            if (dbUsername == null || dbPassword == null) {
//                throw new IllegalArgumentException("DB_USERNAME or DB_PASSWORD is not set in the .env file");
//            }
//
//            System.out.println("DB_USERNAME: " + dbUsername);
//            System.out.println("DB_PASSWORD: " + dbPassword);
//
//            env.getSystemProperties().put("DB_USERNAME", dbUsername);
//            env.getSystemProperties().put("DB_PASSWORD", dbPassword);
//
//            // 验证设置的系统属性
//            System.out.println("System Property DB_USERNAME: " + System.getProperty("DB_USERNAME"));
//            System.out.println("System Property DB_PASSWORD: " + System.getProperty("DB_PASSWORD"));
//        } catch (Exception e) {
//            // 捕获异常并打印错误信息
//            e.printStackTrace();
//        }
//    }
//}
