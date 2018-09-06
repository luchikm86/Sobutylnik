


import com.sobytylnik.InMemoryProfileRepository;
import com.sobytylnik.Profile;
import com.sobytylnik.exception.EntityAlreadyExistsException;
import com.sobytylnik.exception.EntityNotFoundException;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Optional;

public class InMemoryProfileRepositoryTest {
    private Profile friend = new Profile("Sergey", "Apalko", 29);
    private Profile friend1 = new Profile("Max", "Luchenko", 29);
    private Profile friend2 = new Profile("General", "Panama", 29);
    private Profile checkProfile = new Profile("Kolyamba", "Kurenkov", 27);
    InMemoryProfileRepository friendList = new InMemoryProfileRepository();


    @Test
    public void triesToFindProfileById_expectTrue() {
        friendList.save(friend2);

        assertTrue(friendList.findById(friend2.getId()).equals(Optional.of(friend2)));
    }

    @Test
    public void tryToSaveProfileInRepository_expectTrue() {
        friendList.save(friend);
        friendList.save(friend1);
        assertEquals(friendList.findById(friend.getId()), Optional.of(friend));
    }

    @Test(expected = EntityAlreadyExistsException.class)
    public void tryToSaveProfileInRepository_expectException() {
        friendList.save(friend1);
        friendList.save(friend1);

    }

    @Test
    public void tryToMergeProfile_ExpectTrue() {

        friendList.save(friend2);
        checkProfile.setId(friend2.getId());
        friendList.merge(checkProfile);

        assertEquals(friendList.findById(friend2.getId()), Optional.of(checkProfile));
    }

    @Test(expected = EntityNotFoundException.class)
    public void tryToMergeProfile_ExpectExeption() {
        Profile checkProfile2 = new Profile("Kolyamba", "Kurenkov", 27);
        checkProfile2.setId(252L);
        friendList.save(friend2);
        friendList.merge(checkProfile2);
    }

}