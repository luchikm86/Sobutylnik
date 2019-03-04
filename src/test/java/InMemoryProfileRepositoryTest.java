


import com.sobytylnik.InMemoryProfileRepository;
import com.sobytylnik.Profile;
import com.sobytylnik.exception.EntityAlreadyExistsException;
import com.sobytylnik.exception.EntityNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Optional;

public class InMemoryProfileRepositoryTest {
    private Profile friend = new Profile("Sergey", "Apalko", "Paris, France", "12.12.1990",
            "Page", "Page", "Page", "Username");
    private Profile friend1 = new Profile("Max", "Luchenko", "Kiev, Ukraine", "12.12.1987",
            "Page", "Page", "Page", "Username");
    private Profile friend2 = new Profile("General", "Panama", "Paris, France", "12.12.1991",
            "Page", "Page", "Page", "Username");
    private Profile checkProfile = new Profile("Kolyamba", "Kurenkov", "Paris, France", "12.12.1991",
            "Page", "Page", "Page", "Username");
    InMemoryProfileRepository profileRepository = new InMemoryProfileRepository();


    @Test
    public void triesToFindProfileById_expectSuccess() {
        profileRepository.save(friend2);

        assertTrue(profileRepository.findById(friend2.getId()).equals(Optional.of(friend2)));
    }

    @Test
    public void tryToSaveProfileInRepository_expectSuccess() {
        profileRepository.save(friend);
        profileRepository.save(friend1);
        assertEquals(profileRepository.findById(friend.getId()), Optional.of(friend));
    }

    @Test(expected = EntityAlreadyExistsException.class)
    public void tryToSaveAlreadyExestentProfile_ExpectException() {
        profileRepository.save(friend1);
        profileRepository.save(friend1);

    }

    @Test
    public void tryToMergeProfile_expectSuccess() {

        profileRepository.save(friend2);
        checkProfile.setId(friend2.getId());
        profileRepository.merge(checkProfile);

        assertEquals(profileRepository.findById(friend2.getId()), Optional.of(checkProfile));
    }

    @Test(expected = EntityNotFoundException.class)
    public void tryToMergeNonexistentProfile_ExpectException() {
        Profile checkProfile2 = new Profile("Kolyamba", "Kurenkov", "Paris, France", "12.12.1991",
                "Page", "Page", "Page", "Username");
        checkProfile2.setId(252L);
        profileRepository.save(friend2);
        profileRepository.merge(checkProfile2);
    }

}