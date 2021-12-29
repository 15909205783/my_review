package com.yangfan.neo.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration //声明是一个配置类
@ComponentScan("com.yangfan.neo.boot")
public class AppConfig extends WebMvcConfigurationSupport{
}
