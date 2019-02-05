package com.sobytylnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/profiles")
@Valid
public class ProfileController {

    @Autowired
    private SQLSpringProfileRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        List<Profile> profiles = new ArrayList<>();
        repository.findAll().forEach(profiles::add);
        return profiles;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Profile> getProfileByID(@PathVariable("id") Long id){
        if(repository.existsById(id)) {
            return Optional.of(getAllProfiles().stream().filter(profile -> profile.getId().equals(id)).findFirst().get());
        } else{
            return Optional.empty();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Profile createProfile(@RequestBody Profile newProfile) {
        repository.save(newProfile);
        return newProfile;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Optional<Profile> updateProfile(@PathVariable("id") Long id, @RequestBody Profile newProfile) {
        if(repository.existsById(id)){
            repository.save(newProfile);
            return Optional.of(newProfile);
        }
        return Optional.empty();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
