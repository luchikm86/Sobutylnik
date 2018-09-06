package com.sobytylnik;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.sobytylnik.exception.EntityAlreadyExistsException;
import com.sobytylnik.exception.EntityNotFoundException;


public class InMemoryProfileRepository implements ProfileRepository {

    private ConcurrentHashMap<Long, Profile> map = new ConcurrentHashMap<>();

    @Override
    public Optional<Profile> findById(Long id) {

        if (map.containsKey(id)) {
            Profile a = map.get(id);

            return Optional.of(a);
        }
        return Optional.empty();
    }

    /**
     * @throws EntityAlreadyExistsException
     */
    @Override
    public Profile save(Profile profile) {
        if (profile.getId() != null && map.containsKey(profile.getId())) {
            throw new EntityAlreadyExistsException("there is such Profile in the base");

        }
        Long id = new Random().nextLong();
        profile.setId(id);
        map.put(id, profile);
        return profile;
    }

    /**
     * @throws EntityNotFoundException
     */
    @Override
    public void merge(Profile profile) {
        if (!map.containsKey(profile.getId())) {
            throw new EntityNotFoundException("there is no such Profile in the base, try not merge but save option");
        }
        map.put(profile.getId(), profile);
    }

    @Override
    public String toString() {
        return "InMemoryProfileRepository{" +
                "map=" + map +
                '}';
    }
}
