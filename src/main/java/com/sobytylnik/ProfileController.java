package com.sobytylnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProfileController {

    @Autowired
    private ProfileRepository repository;

    @RequestMapping(value="/api/profiles", method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        return repository.findAllProfiles();
    }

    @RequestMapping(value="/api/profiles/{id}", method = RequestMethod.GET)
    public Optional<Profile> getProfileByID(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @RequestMapping(value="/api/profiles", method = RequestMethod.POST)
    public Optional<Profile> createProfile(@RequestBody Profile newProfile) {
        repository.save(newProfile);
        return repository.findById(newProfile.getId());
    }

    @RequestMapping(value="/api/profiles/{id}", method = RequestMethod.PUT)
    public Optional<Profile> updateProfile(@PathVariable("id") Long id, @RequestBody Profile newProfile) {
        newProfile.setId(id);
        repository.merge(newProfile);
        return repository.findById(id);
    }

    @RequestMapping(value="/api/profiles/{id}", method = RequestMethod.DELETE)
    public Optional<Profile> deleteProfile(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return repository.findById(id);
    }
}
