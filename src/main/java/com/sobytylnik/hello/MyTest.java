package com.sobytylnik.hello;



import com.sobytylnik.hello.ExceptionListPackage.EntityAlreadyExistsException;
import com.sobytylnik.hello.ExceptionListPackage.EntityNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class MyTest {
    Profile friend = new Profile(UUID.randomUUID(), "Sergey", "Apalko", 29);
    Profile friend1 = new Profile(UUID.randomUUID(), "Max", "Luchenko", 29);
    Profile friend2 = new Profile(UUID.randomUUID(), "General", "Panama", 29);
    Profile checkProfile = new Profile(UUID.randomUUID(),"Kolyamba","Kurenkov",27);
    InMemoryProfileRepository friendList = new InMemoryProfileRepository();


    @Test
    public void testFindById(){
        friendList.save(friend2);

        assertTrue(friendList.findById(22L).equals(friend2));
    }

    @Test
    public void testSave(){
        friendList.save(friend);
        friendList.save(friend1);
        assertEquals(friendList.findById(13L), friend1);
    }

    @Test(expected = EntityAlreadyExistsException.class)
    public void testSave2(){
        friendList.save(friend1);
        friendList.save(friend1);

    }

    @Test
    public void testMerge(){

        friendList.save(friend2);
        friendList.merge(checkProfile);

        assertEquals(friendList.findById(14L),Optional.of(checkProfile));
    }

    @Test(expected = EntityNotFoundException.class)
    public void testMerge2(){
        Profile checkProfile2 = new Profile(UUID.randomUUID(),"Kolyamba","Kurenkov",27);
        friendList.save(friend2);
        friendList.merge(checkProfile2);
    }

}