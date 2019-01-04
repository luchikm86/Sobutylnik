package com.sobytylnik.quiz;

public class QuizFactory {

    public static Quiz createHobbieQuiz(int id, String text, String description) {
        return new Quiz(QuizType.HOBBIES, id, text, description);
    }

    public static Quiz createIqQuiz(int id, String text, String description) {
        return new Quiz(QuizType.IQ, id, text, description);
    }

    public static Quiz createPoliticalQuiz(int id, String text, String description) {
        return new Quiz(QuizType.POLITICAL, id, text, description);
    }

    public static Quiz createPsychologicalQuiz(int id, String text, String description) {
        return new Quiz(QuizType.PSYCHOLOGICAL, id, text, description);
    }

    public static Quiz createReligionQuiz(int id, String text, String description) {
        return new Quiz(QuizType.RELIGION, id, text, description);
    }

    public static Quiz create(QuizType type, int id, String text, String description) {
        return new Quiz(type, id, text, description);
    }

}


