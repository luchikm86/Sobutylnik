package com.sobytylnik.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuizRunner {
    public static void main(String[] args) throws IOException {
        Quiz iqQuiz = QuizFactory.createIqQuiz();

        List<Option> answer = new ArrayList<>();

        for (Option elem : iqQuiz.returnQuestionByID(1).map(Question::getOptions).get()) {
            System.out.println(elem);
        }

//        answer.add(iqQuiz.returnQuestionByID(1).map(Question::getOptions).get().get(1));
//
//        QuizAnswers iqQuizAnswers = new QuizAnswers(iqQuiz);
//
//        iqQuizAnswers.addAnswer(1,answer);
//
//        System.out.println(iqQuizAnswers.displayAnswer(1));
    }
}
