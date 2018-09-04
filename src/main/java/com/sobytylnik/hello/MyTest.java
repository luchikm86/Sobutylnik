package com.sobytylnik.hello;



import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MyTest {
    Profile friend = new Profile(12L, "Sergey", "Apalko", 29);
    Profile friend1 = new Profile(13L, "Max", "Luchenko", 29);
    Profile friend2 = new Profile(14L, "General", "Panama", 29);
    Profile checkProfile = new Profile(14L,"Kolyamba","Kurenkov",27);
    InMemoryProfileRepository testReposit = new InMemoryProfileRepository(new ConcurrentHashMap<>());

    
    @Test
    public void testFindById(){
        testReposit.save(friend2);

        assertTrue(testReposit.findById(22L).equals(friend2));
    }

    @Test
    public void testSave(){
        testReposit.save(friend);
        testReposit.save(friend1);
        assertEquals(testReposit.findById(13L), friend1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSave2(){
        testReposit.save(friend1);
        testReposit.save(friend1);

    }

    @Test
    public void testMerge(){

        testReposit.save(friend2);
        testReposit.merge(checkProfile);

        assertEquals(testReposit.findById(14L),Optional.of(checkProfile));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMerge2(){
        Profile checkProfile2 = new Profile(145L,"Kolyamba","Kurenkov",27);
        testReposit.save(friend2);
        testReposit.merge(checkProfile2);
    }

}
