package com.sobutylnik.JavaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sobutylnik.hello.IndexController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sobutylnik" })
public class ApplicationConfig {

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }

//    @Bean
//    public InternalResourceViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return jspViewResolver;
//    }

}
