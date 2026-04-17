package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan //让 Spring Boot 能够扫描并注册使用了Filter过滤器组件
@SpringBootApplication
public class TliasWebManagermentApplication {

    public static void main(String[] args) {

        SpringApplication.run(TliasWebManagermentApplication.class, args);
    }

}
