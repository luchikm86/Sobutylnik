package com.sobytylnik.quiz.sobytylnikQuizes;

import com.sobytylnik.quiz.Question;
import com.sobytylnik.quiz.Quiz;

import java.util.List;

public class ReligionQuiz extends Quiz {
    public ReligionQuiz(int id, String text, String description) {
        super(id, text, description);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public String getText() {
        return super.getText();
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
    }

    @Override
    public List<Question> getListOfQuestions() {
        return super.getListOfQuestions();
    }

    @Override
    public void setListOfQuestions(List<Question> listOfQuestions) {
        super.setListOfQuestions(listOfQuestions);
    }

    @Override
    public void addQuestion(Question question) {
        super.addQuestion(question);
    }
}
