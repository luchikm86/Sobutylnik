package com.sobutylnik.JavaConfig;

import org.springframework.aop.interceptor.AbstractMonitoringInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import com.sobutylnik.hello.IndexController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sobutylnik" })
public class ApplicationConfig {

    private AbstractMonitoringInterceptor resolver;

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }


}
