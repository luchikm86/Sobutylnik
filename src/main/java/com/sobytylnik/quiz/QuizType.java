package com.sobytylnik.quiz;

public enum QuizType {
    HOBBIES("Hobbies"),
    POLITICAL("Political"),
    IQ("IQ"),
    PSYCHOLOGICAL("Psychological"),
    RELIGION("Religion");

    private final String name;

    private QuizType(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }

}