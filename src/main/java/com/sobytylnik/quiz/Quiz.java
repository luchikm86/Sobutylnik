package com.sobytylnik.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private String text;
    private String description;
    private List<Question> listOfQuestions;

    public Quiz(int id, String text, String description) {
        this.id = id;
        this.text = text;
        this.description = description;
        this.listOfQuestions = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getListOfQuestions() {
        return listOfQuestions;
    }

    public void setListOfQuestions(List<Question> listOfQuestions) {
        this.listOfQuestions = listOfQuestions;
    }

    public void addQuestion(Question question){
        listOfQuestions.add(question);
    }

    public Question returnQuestionbyID(int id){

        for (Question elem: listOfQuestions) {

            if (elem.getId() == id) {
                return elem;
            }
        }

        return null;
    }

}
