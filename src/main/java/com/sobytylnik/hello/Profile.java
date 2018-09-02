package com.sobytylnik.hello;

import java.util.Objects;

public class Profile {
    private final Long id;
    private String name;
    private String surname;
    private int age;

    public Profile(Long id, String name, String surname, int age) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void changeName(String newName) {
        name = newName;
    }

    public void changeSurName(String newSurName) {
        surname = newSurName;

    }

    public void changeAge(int newAge) {
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
