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
    private ProfileRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        List<Profile> profiles = new ArrayList<>();
        repository.findAll().forEach(profiles::add);
        return profiles;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Profile> findProfileById(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Optional<Profile> saveProfile(@RequestBody Profile newProfile) {
        repository.save(newProfile);
        return Optional.of(newProfile);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Optional<Profile> mergeProfile(@PathVariable("id") Long id, @RequestBody Profile newProfile) {
        Profile profile = newProfile;
        profile.setId(id);
        repository.save(profile);
        return repository.findById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteProfileById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
