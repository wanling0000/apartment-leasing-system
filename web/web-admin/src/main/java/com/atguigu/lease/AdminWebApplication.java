package com.atguigu.lease;

import com.atguigu.lease.web.admin.custom.config.EnvLoader;
import io.github.cdimascio.dotenv.Dotenv;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.nio.file.Paths;

@SpringBootApplication
@MapperScan("com.atguigu.lease.web.admin.mapper")
@ComponentScan(
        basePackages = {"com.atguigu.lease.web.admin", "com.atguigu.lease.common"})
@EnableScheduling

public class AdminWebApplication {
    public static void main(String[] args) {
        EnvLoader.loadEnv();
        SpringApplication.run(AdminWebApplication.class, args);
    }
}