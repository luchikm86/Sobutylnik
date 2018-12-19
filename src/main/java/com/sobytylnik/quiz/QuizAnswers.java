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
        for (Question elem:quiz.getListOfQuestions()) {
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

    private String displayAnswers(int questionID){
        String output = answers.get(questionID).get(questionID).getText();

        if (answers.size() > 1) {
            for (int i = 1; i < answers.size(); i++) {
                output = output + ", " + answers.get(questionID).get(i);
            }
        }

        return output;
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
