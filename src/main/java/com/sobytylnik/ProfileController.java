package com.sobytylnik;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Profile> getProfileByID(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @RequestMapping(value="/new", method = RequestMethod.POST)
    public Optional<Profile> createProfile(Profile newProfile) {
        repository.save(newProfile);
        return repository.findById(newProfile.getId());
    }

    @RequestMapping(value="/update/{id}", method = RequestMethod.PUT)
    public Optional<Profile> updateProfile(@PathVariable("id") Long id, Profile newProfile) {
        newProfile.setId(id);
        repository.merge(newProfile);
        return repository.findById(id);
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
    public Optional<Profile> deleteProfile(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return repository.findById(id);
    }
}
