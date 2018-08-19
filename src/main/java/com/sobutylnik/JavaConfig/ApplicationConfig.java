package com.sobutylnik.JavaConfig;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.sobutylnik" })
public class ApplicationConfig {



}
