package com.sobytylnik;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SQLSpringProfileRepository extends CrudRepository<Profile, Long> {

    //Find by ID
    Optional<Profile> findById(Long id);

    //Save Profile
    //Merge Profile
    <S extends Profile> S save(S var1);

    //Delete Profile
    void deleteById(Long id);

    //Get Profiles
    List<Profile> findAll();



}
