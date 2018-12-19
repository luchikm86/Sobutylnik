package com.sobytylnik.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private int ordinal;
    private String text;
    private boolean isMultiChoice;
    private List<Option> listOfOptions;

    public Question(int id, int ordinal, String text, boolean isMultiChoice) {
        this.id = id;
        this.ordinal = ordinal;
        this.text = text;
        this.isMultiChoice = isMultiChoice;
        this.listOfOptions = new ArrayList<>();
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

    public boolean isMultiChoice() {
        return isMultiChoice;
    }

    public void setMultiChoice(boolean multiChoice) {
        isMultiChoice = multiChoice;
    }

    public List<Option> getListOfOptions() {
        return listOfOptions;
    }

    public void setListOfOptions(List<Option> listOfOptions) {
        this.listOfOptions = listOfOptions;
    }

    public void addOption(Option option){
        listOfOptions.add(option);
    }
}
