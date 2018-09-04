package com.sobytylnik.hello;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    public static void main(String[] args) {
        ConcurrentHashMap b = new ConcurrentHashMap();
        Profile friend = new Profile(UUID.randomUUID(), "Sergey", "Apalko", 29);
        Profile friend1 = new Profile(UUID.randomUUID(), "Max", "Luchenko", 29);
        Profile friend2 = new Profile(UUID.randomUUID(), "General", "Panama", 29);
        System.out.println(friend);
        ConcurrentHashMap friendList = new ConcurrentHashMap();
        InMemoryProfileRepository test = new InMemoryProfileRepository();
        System.out.println(test.save(friend));
        test.save(friend1);
//        System.out.println(test);
//        friend.setSurName("Random");
//        test.merge(friend);
//        System.out.println(test);
        System.out.println(test);
        System.out.println(test.findById(friend.getId()));


    }
}
