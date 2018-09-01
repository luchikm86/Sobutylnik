package com.sobutylnik.hello;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryProfileRepository implements ProfileRepository {


    private final ConcurrentHashMap<Long, Profile> ProfileMap;

    public InMemoryProfileRepository(ConcurrentHashMap<Long, Profile> profileMap) {
        ProfileMap = profileMap;
    }


    public ConcurrentHashMap getProfileMap() {
        return ProfileMap;
    }


    @Override
    public Optional<Profile> findById(Long id) {

        if (ProfileMap.containsKey(id)) {
            Profile a = ProfileMap.get(id);


            return Optional.of(a);
        }
        return Optional.empty();
    }

    @Override
    public Profile save(Profile profile) {
        if (ProfileMap.containsKey(profile.getId())) {
            throw new IllegalArgumentException("there is such Profile in the base");

        }
        ProfileMap.put(profile.getId(), profile);
        return profile;
    }

    @Override
    public void merge(Profile profile) {
        if (!ProfileMap.containsKey(profile.getId())) {
            throw new IllegalArgumentException("there is no such Profile in the base, try not merge but save option");
        }
        if (ProfileMap.get(profile.getId()).getAge() != profile.getAge()) {
            ProfileMap.get(profile.getId()).changeAge(profile.getAge());
        }
        if (ProfileMap.get(profile.getId()).getName() != profile.getName()) {
            ProfileMap.get(profile.getId()).changeName(profile.getName());
        }
        if (ProfileMap.get(profile.getId()).getSurname() != profile.getSurname()) {
            ProfileMap.get(profile.getId()).changeSurName(profile.getSurname());
        }
    }

    @Override
    public String toString() {
        return "InMemoryProfileRepository{" +
                "ProfileMap=" + ProfileMap +
                '}';
    }
}
