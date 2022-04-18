package com.yangfan.neo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yangfan.neo.dao.mapper")
@EnableApolloConfig
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
