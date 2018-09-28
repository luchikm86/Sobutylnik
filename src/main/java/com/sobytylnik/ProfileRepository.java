package com.sobytylnik;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> findById(Long id);

    /**
     * @return the profile with generated id.
     */
    Profile save(Profile profile);

    void merge(Profile profile);

    void deleteById(long id);

    List<Profile> findAllProfiles();
}