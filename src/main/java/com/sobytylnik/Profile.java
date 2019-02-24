package com.sobytylnik;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Pattern(regexp="^[a-zA-Z]+")
    private String name;
    @Column(name = "surname")
    @Pattern(regexp="^[a-zA-Z]+")
    private String surname;
    @Column(name = "age")
    @Min(value = 1, message = "Age should not be less than 1")
    @Max(value = 120, message = "Age should not be greater than 120")
    private int age;

    @Column(name = "location")
    @Pattern(regexp="^[a-zA-Z]+")
    private String location;

    @Column(name = "language")
    @Pattern(regexp="^[a-zA-Z]+")
    private String language;

    @Column(name = "birthDate")
    @Past
    private Date birthDate;

    @Column(name = "TwitterPage")
    @Pattern(regexp="^[a-zA-Z]+")
    private String TwitterPage;

    @Column(name = "InstagramPage")
    @Pattern(regexp="^[a-zA-Z]+")
    private String InstagramPage;

    @Column(name = "FacebookPage")
    @Pattern(regexp="^[a-zA-Z]+")
    private String FacebookPage;

    @Column(name = "TelegramUserName")
    @Pattern(regexp="^[a-zA-Z]+")
    private String TelegramUserName;


    public Profile(){
    }

    public Profile(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Profile(String name, String surname, String location,
                  String language, String twitterPage, String instagramPage,
                   String facebookPage, String telegramUserName) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.location = location;
        this.language = language;
        this.birthDate = birthDate;
        TwitterPage = twitterPage;
        InstagramPage = instagramPage;
        FacebookPage = facebookPage;
        TelegramUserName = telegramUserName;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) { this.surname = surname; }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTwitterPage() {
        return TwitterPage;
    }

    public void setTwitterPage(String twitterPage) {
        TwitterPage = twitterPage;
    }

    public String getInstagramPage() {
        return InstagramPage;
    }

    public void setInstagramPage(String instagramPage) {
        InstagramPage = instagramPage;
    }

    public String getFacebookPage() {
        return FacebookPage;
    }

    public void setFacebookPage(String facebookPage) {
        FacebookPage = facebookPage;
    }

    public String getTelegramUserName() {
        return TelegramUserName;
    }

    public void setTelegramUserName(String telegramUserName) {
        TelegramUserName = telegramUserName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return id == profile.id;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", location='" + location + '\'' +
                ", language='" + language + '\'' +
                ", birthDate=" + birthDate +
                ", TwitterPage='" + TwitterPage + '\'' +
                ", InstagramPage='" + InstagramPage + '\'' +
                ", FacebookPage='" + FacebookPage + '\'' +
                ", TelegramUserName='" + TelegramUserName + '\'' +
                '}';
    }
}
