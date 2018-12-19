package com.sobytylnik.quiz;

import com.sobytylnik.quiz.sobytylnikQuizes.IQQuiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuizRunner {
    public static void main(String[] args) throws IOException {
        Quiz iqQuiz = new IQQuiz(1,"IQ test","This test will show your intelligence level");
        Question question = new Question(1,1,"how much is 2+2 ?", false);

        List<Option> answer = new ArrayList<>();
        List<Option> options = new ArrayList<>();

        Option option1 = new Option(1,1,"1");
        Option option2 = new Option(1,2,"4");
        Option option3 = new Option(1,3,"8");
        Option option4 = new Option(1,4,"0");

        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);

        question.setListOfOptions(options);
        answer.add(option2);

        iqQuiz.addQuestion(question);

        QuizAnswers iqQuizAnswers = new QuizAnswers(iqQuiz);

        iqQuizAnswers.addAnswer(1,answer);

        System.out.println(iqQuizAnswers.displayAnswer(1));
    }
}
