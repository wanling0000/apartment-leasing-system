package com.atguigu.lease.web.admin.custom.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.nio.file.Paths;

public class EnvLoader {

    private static String minioAccessKey;
    private static String minioSecretKey;

    public static void loadEnv() {
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

        minioAccessKey = dotenv.get("MINIO_ACCESS_KEY");
        minioSecretKey = dotenv.get("MINIO_SECRET_KEY");

        System.out.println("DB_USERNAME: " + dotenv.get("DB_USERNAME"));
        System.out.println("DB_PASSWORD: " + dotenv.get("DB_PASSWORD"));
    }

    public static String getMinioAccessKey() {
        return minioAccessKey;
    }

    public static String getMinioSecretKey() {
        return minioSecretKey;
    }
}

