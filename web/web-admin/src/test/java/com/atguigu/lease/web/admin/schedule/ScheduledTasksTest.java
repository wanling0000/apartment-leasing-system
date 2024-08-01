package com.atguigu.lease.web.admin.schedule;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduledTasksTest {
    @Autowired
    private ScheduledTasks scheduledTasks;
    @BeforeAll
    public static void setup() {
        String currentDir = Paths.get("").toAbsolutePath().toString();
        System.out.println("Current working directory: " + currentDir);

        // 确保构建正确的路径
        String envPath = Paths.get(currentDir, "src", "main", "resources").toAbsolutePath().toString();
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
    }

    @Test
    void contextLoads() {
        System.out.println("MINIO_ACCESS_KEY: " + System.getProperty("MINIO_ACCESS_KEY"));
        System.out.println("MINIO_SECRET_KEY: " + System.getProperty("MINIO_SECRET_KEY"));
    }


    @Test
    public void test(){
        scheduledTasks.checkLeaseStatus();
    }
}