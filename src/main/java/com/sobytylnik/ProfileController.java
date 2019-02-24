package com.sobytylnik;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/profiles")
@Valid
public class ProfileController {


    @Autowired
    @Qualifier("profileRepository")
    private ProfileRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Profile> getAllProfiles(){
        return new ArrayList<>((Collection<? extends Profile>) repository.findAll());
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Optional<Profile> getProfileByID(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Profile createProfile(@RequestBody Profile newProfile) {
        return repository.save(newProfile);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Optional<Profile> updateProfile(@PathVariable("id") Long id, @RequestBody Profile newProfile) {
        if(repository.existsById(id)){
            newProfile.setId(id);
            repository.save(newProfile);
            return repository.findById(id);
        } else{
            return Optional.empty();
        }

    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteProfile(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
