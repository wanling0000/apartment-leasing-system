package com.atguigu.lease;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;

@SpringBootApplication
public class AdminWebApplication {
    public static void main(String[] args) {
        String envPath = Paths.get("web/web-admin/src/main/resources").toAbsolutePath().toString();
        System.out.println("Loading .env from: " + envPath);

        Dotenv dotenv = Dotenv.configure()
                .directory(envPath)
                .filename(".env")
                .load();

        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        System.out.println("DB_USERNAME: " + dotenv.get("DB_USERNAME"));
        System.out.println("DB_PASSWORD: " + dotenv.get("DB_PASSWORD"));

        SpringApplication.run(AdminWebApplication.class, args);
    }
}
