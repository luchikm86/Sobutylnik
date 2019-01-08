package com.sobytylnik.quiz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class QuizAnswers {
    private Quiz quiz;
    private Map<Integer, List<Option>> answers;

    public QuizAnswers(Quiz quiz) {
        this.quiz = quiz;
        this.answers = new HashMap<>();
        for (Question elem:quiz.getQuestions()) {
            answers.put(elem.getId(),null);
        }
    }

    public void addAnswer(int questionID, List<Option> answers){
        this.answers.put(questionID,answers);
    }

    public Map<Integer, List<Option>> getAnswers() {
        return answers;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String displayAnswer(int questionID){
        StringJoiner questionAnswers = new StringJoiner(",");
        for (Option option : answers.get(questionID)) {
            questionAnswers.add(option.getText());
        }
        return "Question id# " + questionID + ", answer: " + questionAnswers.toString();
    }
}
