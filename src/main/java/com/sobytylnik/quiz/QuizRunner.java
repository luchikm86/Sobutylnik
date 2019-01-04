package com.sobytylnik.quiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizRunner {
    public static void main(String[] args) throws IOException {
        Quiz iqQuiz = QuizFactory.createIqQuiz(1,"IQ test","This test will show your intelligence level");
        Question question = new Question(1,1,"how much is 2+2 ?", false);

        List<Option> answer = new ArrayList<>();

        Option option1 = new Option(1,1,"1");
        Option option2 = new Option(1,2,"4");
        Option option3 = new Option(1,3,"8");
        Option option4 = new Option(1,4,"0");

        List<Option> options = Arrays.asList(option1, option2, option3, option4);

        question.setOptions(options);
        answer.add(option2);

        iqQuiz.addQuestion(question);

        QuizAnswers iqQuizAnswers = new QuizAnswers(iqQuiz);

        iqQuizAnswers.addAnswer(1,answer);

        System.out.println(iqQuizAnswers.displayAnswer(1));
    }
}
