package com.sobytylnik;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("profileService")
@Transactional
public class SQLProfileRepository implements ProfileRepository {

    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public Optional<Profile> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Profile profile = (Profile) session.get(Profile.class, id);
        return Optional.of(profile);
    }

    @Override
    public Profile save(Profile profile) {
        Session session = sessionFactory.getCurrentSession();
        session.save(profile);
        return profile;
    }

    @Override
    public void merge(Profile profile) {
        Session session = sessionFactory.getCurrentSession();
        Profile existingPerson = (Profile) session.get(Profile.class, profile.getId());
        existingPerson.setName(profile.getName());
        existingPerson.setSurname(profile.getSurname());
        existingPerson.setAge(profile.getAge());
        session.save(existingPerson);
    }

    @Override
    public void deleteById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Profile profile = (Profile) session.get(Profile.class, id);
        session.delete(profile);
    }

    @Override
    public List<Profile> findAllProfiles() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM  Person");
        return  query.list();
    }
}
