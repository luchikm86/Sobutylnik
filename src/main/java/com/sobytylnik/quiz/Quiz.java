package com.sobytylnik.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Quiz {
    private QuizType type;
    private int id;
    private String text;
    private String description;
    private List<Question> questions;

    public Quiz(QuizType type, int id, String text, String description) {
        this.type = type;
        this.id = id;
        this.text = text;
        this.description = description;
        this.questions = new ArrayList<>();
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public QuizType getType() {
        return type;
    }

    public void setType(QuizType type) {
        this.type = type;
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public Optional<Question> returnQuestionbyID(int id){

        for (Question elem: questions) {

            if (elem.getId() == id) {
                return Optional.of(elem);
            }
        }

        return Optional.empty();
    }

}
