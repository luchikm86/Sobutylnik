package com.sobytylnik;

import com.sobytylnik.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ProfileController {

    private ConcurrentHashMap<Long, Profile> map;

    public ProfileController(InMemoryProfileRepository repository) {
        this.map = repository.getMap();
    }

    @RequestMapping(value="/profiles", method = RequestMethod.GET)
    public ArrayList<Profile> getAllProfiles(){
        ArrayList list = new ArrayList<Profile>();
        for (ConcurrentHashMap.Entry<Long, Profile> entry : map.entrySet())
        {
            list.add(entry);
        }
        return list;
    }

    @RequestMapping(value="/profiles/{id}", method = RequestMethod.GET)
    public Profile getProfileByID(@PathVariable("id") long id){
        if (!map.containsKey(id)){
            throw new EntityNotFoundException("404 - Profile is not found");
        }
        return map.get(id);
    }

    public Profile updateProfile(long id, Profile newProfile) {
        if (!map.containsKey(id)){
            throw new EntityNotFoundException("404 - Profile is not found");
        }

        map.put(id,newProfile);

        return map.get(id);
    }

    public void deleteProfile(long id) {
        if (!map.containsKey(id)){
            throw new EntityNotFoundException("404 - Profile is not found");
        }
        map.remove(id);
    }



    // Test
//    @RequestMapping("/hello")
//    public String sayHi(){
//        return "Hi!";
//    }
}
