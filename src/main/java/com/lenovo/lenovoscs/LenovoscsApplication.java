package com.lenovo.lenovoscs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.lenovo.lenovoscs.dao")
public class LenovoscsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LenovoscsApplication.class, args);
    }
}

