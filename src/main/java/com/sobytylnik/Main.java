package com.sobytylnik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ProfileRepository repository){
//        return args -> {
//            Profile friend1 = new Profile("Sergey", "Apalko", 29);
//            Profile friend2 = new Profile("Max", "Luchenko", 29);
//            Profile friend3 = new Profile("General", "Panama", 29);
//            repository.save(friend1);
//            repository.save(friend2);
//            repository.save(friend3);
//        };
//    }

}

//http://localhost:8080