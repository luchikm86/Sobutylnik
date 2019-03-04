package com.sobytylnik;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

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
    @Column(name = "location")
    private String location;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "twitter_page")
    private String twitterPage;
    @Column(name = "instagram_page")
    private String instagramPage;
    @Column(name = "facebook_page")
    private String facebookPage;
    @Column(name = "telegram_username")
    private String telegramUsername;

    public Profile(){
    }

    public Profile(String name, String surname, String location, String birthday, String twitterPage,
                   String instagramPage, String facebookPage, String telegramUsername) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.birthday = birthday;
        this.twitterPage = twitterPage;
        this.instagramPage = instagramPage;
        this.facebookPage = facebookPage;
        this.telegramUsername = telegramUsername;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getTwitterPage() {
        return twitterPage;
    }

    public void setTwitterPage(String twitterPage) {
        this.twitterPage = twitterPage;
    }

    public String getInstagramPage() {
        return instagramPage;
    }

    public void setInstagramPage(String instagramPage) {
        this.instagramPage = instagramPage;
    }

    public String getFacebookPage() {
        return facebookPage;
    }

    public void setFacebookPage(String facebookPage) {
        this.facebookPage = facebookPage;
    }

    public String getTelegramUsername() {
        return telegramUsername;
    }

    public void setTelegramUsername(String telegramUsername) {
        this.telegramUsername = telegramUsername;
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
                ", location='" + location + '\'' +
                ", birthday='" + birthday + '\'' +
                ", twitterPage='" + twitterPage + '\'' +
                ", instagramPage='" + instagramPage + '\'' +
                ", facebookPage='" + facebookPage + '\'' +
                ", telegramUsername='" + telegramUsername + '\'' +
                '}';
    }
}
