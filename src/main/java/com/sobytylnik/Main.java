package com.sobytylnik;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
        InMemoryProfileRepository repository = new InMemoryProfileRepository();
        Profile kolya = new Profile("Kolya","Kurenkov",27);
        Profile artur = new Profile("Artur","Gamburf",33);

        repository.save(kolya);
        repository.save(artur);

        ProfileController controllerP = new ProfileController(repository);
        System.out.println("Get All Profiles:");
        controllerP.getAllProfiles();
        System.out.println("Get By ID:");
        controllerP.getProfileByID(kolya.getId());
        System.out.println("Update Profile:");
        controllerP.updateProfile(kolya.getId(), new Profile("Kolyamba","Supeman", 27));
        System.out.println("Delete Profile and List all profiles:");
        controllerP.deleteProfile(kolya.getId());
        controllerP.getAllProfiles();
    }
}


//http://localhost:8080