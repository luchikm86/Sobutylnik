package com.sobytylnik.hello;

import java.util.Optional;
import java.util.UUID;

public interface ProfileRepository {

    Optional<Profile> findById(Long id);

    /**
     * @return the profile with generated id.
     */
    Profile save(Profile profile);

    void merge(Profile profile);
}