package com.record_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.record_test.mapper") //Mapper类包扫描
@SpringBootApplication
@Configuration
@EnableTransactionManagement
public class RecordTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecordTestApplication.class, args);
    }

}
