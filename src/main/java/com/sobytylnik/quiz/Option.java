package com.sobytylnik.quiz;

public class Option {
    private int id;
    private int ordinal;
    private String text;

    public Option(int id, int ordinal, String text) {
        this.id = id;
        this.ordinal = ordinal;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
