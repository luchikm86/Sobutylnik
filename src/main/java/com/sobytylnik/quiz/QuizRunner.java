package com.sobytylnik.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizRunner {
    public static void main(String[] args) throws IOException {
        Quiz iqQuiz = QuizFactory.createIqQuiz();

        List<Option> answerIQ = new ArrayList<>();

        System.out.println("Question:");
        System.out.println(iqQuiz.getQuestionByID(1).map(Question::getText).get());
        System.out.println();

        System.out.println("Options:");
        for (Option elem : iqQuiz.getQuestionByID(1).map(Question::getOptions).get()) {
            System.out.println(elem.getText());
        }

        answerIQ.add(iqQuiz.getQuestionByID(1).map(Question::getOptions).get().get(1));

        QuizAnswers iqQuizAnswers = new QuizAnswers(iqQuiz);

        iqQuizAnswers.addAnswer(1,answerIQ);

        System.out.println();
        System.out.println("Answer:");
        System.out.println(iqQuizAnswers.displayAnswer(1));

        System.out.println();

        System.out.println("*****");

        System.out.println();

        Quiz hobbiesQuiz = QuizFactory.createHobbieQuiz();

        List<Option> answerHobbies = new ArrayList<>();
        System.out.println("Question:");
        System.out.println(hobbiesQuiz.getQuestionByID(2).map(Question::getText).get());
        System.out.println();

        System.out.println("Options:");
        for (Option elem : hobbiesQuiz.getQuestionByID(2).map(Question::getOptions).get()) {
            System.out.println(elem.getText());
        }

        answerHobbies.add(hobbiesQuiz.getQuestionByID(2).map(Question::getOptions).get().get(0));
        answerHobbies.add(hobbiesQuiz.getQuestionByID(2).map(Question::getOptions).get().get(1));
        answerHobbies.add(hobbiesQuiz.getQuestionByID(2).map(Question::getOptions).get().get(4));

        QuizAnswers hobbiesAnswer = new QuizAnswers(hobbiesQuiz);

        hobbiesAnswer.addAnswer(2,answerHobbies);

        System.out.println();
        System.out.println("Answer:");
        System.out.println(hobbiesAnswer.displayAnswer(2));

    }
}
