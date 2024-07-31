package com.atguigu.lease;

import io.github.cdimascio.dotenv.Dotenv;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;

@SpringBootApplication
@MapperScan("com.atguigu.lease.web.admin.mapper")
public class AdminWebApplication implements CommandLineRunner {
    public static void main(String[] args) {
        String envPath = Paths.get("web/web-admin/src/main/resources").toAbsolutePath().toString();
        System.out.println("Loading .env from: " + envPath);

        Dotenv dotenv = Dotenv.configure()
                .directory(envPath)
                .filename(".env")
                .load();

        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
        System.setProperty("MINIO_ACCESS_KEY", dotenv.get("MINIO_ACCESS_KEY"));
        System.setProperty("MINIO_SECRET_KEY", dotenv.get("MINIO_SECRET_KEY"));

        System.out.println("DB_USERNAME: " + dotenv.get("DB_USERNAME"));
        System.out.println("DB_PASSWORD: " + dotenv.get("DB_PASSWORD"));
        System.out.println("MINIO_ACCESS_KEY: " + dotenv.get("MINIO_ACCESS_KEY"));
        System.out.println("MINIO_SECRET_KEY: " + dotenv.get("MINIO_SECRET_KEY"));

        SpringApplication.run(AdminWebApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MINIO_ACCESS_KEY: " + System.getProperty("MINIO_ACCESS_KEY"));
        System.out.println("MINIO_SECRET_KEY: " + System.getProperty("MINIO_SECRET_KEY"));
    }
}
