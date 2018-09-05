package com.sobytylnik.hello;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.sobytylnik.hello.ExceptionListPackage.EntityAlreadyExistsException;
import com.sobytylnik.hello.ExceptionListPackage.EntityNotFoundException;


public class InMemoryProfileRepository implements ProfileRepository {


    ConcurrentHashMap<Long, Profile> ProfileMap = new ConcurrentHashMap<>();


@Override
    public Optional<Profile> findById(Long id) {

        if (ProfileMap.containsKey(id)) {
            Profile a = ProfileMap.get(id);


            return Optional.of(a);
        }
        return Optional.empty();
    }



    /**
     * @throws EntityAlreadyExistsException
     */
    @Override
    public Profile save(Profile profile) {
        if (ProfileMap.containsKey(profile.getId())) {
            throw new EntityAlreadyExistsException("there is such Profile in the base");

        }
        ProfileMap.put(profile.getId(), profile);
        return profile;
    }

    /**
     * @throws EntityNotFoundException
     */
    @Override
    public void merge(Profile profile) {
        if (!ProfileMap.containsKey(profile.getId())) {
            throw new EntityNotFoundException("there is no such Profile in the base, try not merge but save option");
        }
        if (ProfileMap.get(profile.getId()).getAge() != profile.getAge()) {
            ProfileMap.put(profile.getId(), profile);
        }
        if (ProfileMap.get(profile.getId()).getName() != profile.getName()) {
            ProfileMap.put(profile.getId(), profile);
        }
        if (ProfileMap.get(profile.getId()).getSurname() != profile.getSurname()) {
            ProfileMap.put(profile.getId(), profile);
        }
    }

    @Override
    public String toString() {
        return "InMemoryProfileRepository{" +
                "ProfileMap=" + ProfileMap +
                '}';
    }
}
