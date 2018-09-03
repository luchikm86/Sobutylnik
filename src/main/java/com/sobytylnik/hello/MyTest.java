package com.sobytylnik.hello;



import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MyTest {
    Profile friend = new Profile(12L, "Sergey", "Apalko", 29);
    Profile friend1 = new Profile(13L, "Max", "Luchenko", 29);
    Profile friend2 = new Profile(12L, "General", "Panama", 29);

    ConcurrentHashMap friendList = new ConcurrentHashMap();
    InMemoryProfileRepository testReposit = new InMemoryProfileRepository(friendList);




    @Test
public void testRepository(){
testReposit.save(friend);


        assertEquals(Optional.of(friend), testReposit.findById(12L));
        assertEquals(friend1, testReposit.save(friend1));
        



    }
}
