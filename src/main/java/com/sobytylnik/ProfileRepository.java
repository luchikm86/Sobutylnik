package com.sobytylnik;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
