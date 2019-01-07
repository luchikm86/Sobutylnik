package com.sobytylnik.quiz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String answer ="Question id# " + questionID + ", answer: ";
        for (Option elem:answers.get(questionID)) {
            answer = answer + elem.getText() + ",";
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}
