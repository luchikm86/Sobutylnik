package com.sobytylnik;

import com.sobytylnik.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

@RestController
public class ProfileController {

    private ConcurrentHashMap<Long, Profile> map;

    public ProfileController(InMemoryProfileRepository repository) {
        this.map = repository.getMap();
    }

    public void getAllProfiles(){
        for (ConcurrentHashMap.Entry<Long, Profile> entry : map.entrySet())
        {
            System.out.println("{\n" +
                    "       \"id\": " + entry.getValue().getId() + ",\n" +
                    "       \"name\": " + entry.getValue().getName() + ",\n" +
                    "       \"surname\": " + entry.getValue().getSurname() + ",\n" +
                    "       \"age\": " + entry.getValue().getAge() + "\n" +
                    "}");
        }
    }

    public void getProfileByID(long id){
        if (!map.containsKey(id)){
            throw new EntityNotFoundException("404 - Profile is not found");
        }
        System.out.println("{\n" +
                "       \"id\": " + map.get(id).getId() + ",\n" +
                "       \"name\": " + map.get(id).getName() + ",\n" +
                "       \"surname\": " + map.get(id).getSurname() + ",\n" +
                "       \"age\": " + map.get(id).getAge() + "\n" +
                "}");
    }

    public void updateProfile(long id, Profile newProfile) {
        if (!map.containsKey(id)){
            throw new EntityNotFoundException("404 - Profile is not found");
        }
        map.get(id).setAge(newProfile.getAge());
        map.get(id).setName(newProfile.getName());
        map.get(id).setSurname(newProfile.getSurname());

        System.out.println("{\n" +
                "       \"id\": " + map.get(id).getId() + ",\n" +
                "       \"name\": " + map.get(id).getName() + ",\n" +
                "       \"surname\": " + map.get(id).getSurname() + ",\n" +
                "       \"age\": " + map.get(id).getAge() + "\n" +
                "}");
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
