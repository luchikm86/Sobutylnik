package com.sobytylnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController

public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @RequestMapping(value="/profiles", method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        return repository.findAllProfiles();
    }

    @RequestMapping(value="/profiles/{id}", method = RequestMethod.GET)
    public Optional<Profile> getProfileByID(@PathVariable("id") long id){
        return repository.findById(id);
    }

    public Optional<Profile> updateProfile(long id, Profile newProfile) {
        repository.merge(newProfile);
        return repository.findById(id);
    }

    public void deleteProfile(long id) {
        repository.deleteById(id);
    }



    // Test
//    @RequestMapping("/hello")
//    public String sayHi(){
//        return "Hi!";
//    }
}
