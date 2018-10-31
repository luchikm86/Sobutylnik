package com.sobytylnik;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class SQLProfileRepository implements ProfileRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Profile> findById(Long id) {
        return Optional.of(entityManager.find(Profile.class,id));
    }

    @Override
    public Profile save(Profile profile) {
        entityManager.persist(profile);
        return profile;
    }

    @Override
    public void merge(Profile profile) {
        findById(profile.getId()).ifPresent(existingPerson -> {
            existingPerson.setName(profile.getName());
            existingPerson.setSurname(profile.getSurname());
            existingPerson.setAge(profile.getAge());
            save(existingPerson);
        });
    }

    @Override
    public void deleteById(long id) {
        findById(id).ifPresent(profile ->{
            entityManager.remove(profile);
        });
    }

    @Override
    public List<Profile> findAllProfiles() {
        return  entityManager.createQuery("select p from Profile p", Profile.class).getResultList();
    }
}
