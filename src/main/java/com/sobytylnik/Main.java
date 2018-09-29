package com.sobytylnik;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx){
        return args -> {
            ProfileRepository repository = new InMemoryProfileRepository();
            Profile friend1 = new Profile("Sergey", "Apalko", 29);
            Profile friend2 = new Profile("Max", "Luchenko", 29);
            Profile friend3 = new Profile("General", "Panama", 29);
            repository.save(friend1);
            repository.save(friend2);
            repository.save(friend3);
            new ProfileController();
            System.out.println(friend1.getId());
        };
    }
}


//http://localhost:8080