package com.sobutylnik.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorld {
    public static void main(String[] args) {
        
//        Runnable helloPrinter = () -> System.out.println("Hello");
//        helloPrinter.run();

        SpringApplication.run(HelloWorld.class, args);
    }
}