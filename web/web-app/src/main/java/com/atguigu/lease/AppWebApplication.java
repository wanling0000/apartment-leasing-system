package com.atguigu.lease;


import com.atguigu.lease.web.app.custom.config.EnvLoader;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication

@MapperScan(
        basePackages = "com.atguigu.lease.web.app.mapper",
        sqlSessionFactoryRef = "appSqlSessionFactory"
)
@ComponentScan(
        basePackages = {"com.atguigu.lease.web.app", "com.atguigu.lease.common"},
        nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class)
@EnableAsync
public class AppWebApplication {

    public static void main(String[] args) {
        com.atguigu.lease.web.app.custom.config.EnvLoader.loadEnv();

        SpringApplication.run(AppWebApplication.class, args);
    }
}
