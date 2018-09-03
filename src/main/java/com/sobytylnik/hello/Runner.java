package com.sobytylnik.hello;

import java.util.concurrent.ConcurrentHashMap;

public class Runner {
    public static void main(String[] args) {
        ConcurrentHashMap b = new ConcurrentHashMap();
        Profile friend = new Profile(12L, "Sergey", "Apalko", 29);
        Profile friend1 = new Profile(13L, "Max", "Luchenko", 29);
        Profile friend2 = new Profile(14L, "General", "Panama", 29);
        System.out.println(friend);
        ConcurrentHashMap friendList = new ConcurrentHashMap();
        InMemoryProfileRepository test = new InMemoryProfileRepository(friendList);
        test.save(friend);
        test.save(friend1);
//        System.out.println(test);
//        friend.changeSurName("Random");
//        test.merge(friend);
//        System.out.println(test);
        System.out.println(test.findById(12L));


    }
}
