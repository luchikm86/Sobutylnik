package com.sobytylnik.hello;

import ch.qos.logback.classic.db.names.DBNameResolver;

import java.util.Objects;
import java.util.UUID;

public class Profile {
    private final UUID id;
    private String name;
    private String surname;
    private int age;

    public Profile(UUID id, String name, String surname, int age) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public UUID getId() {
        return id;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setSurName(String newSurName) {
        surname = newSurName;

    }

    public void setAge(int newAge) {
        age = newAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
