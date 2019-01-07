package com.sobytylnik.quiz;

import java.util.Optional;

public class QuizFactory {

    public static Quiz createHobbieQuiz() {
        Quiz quiz = new Quiz(QuizType.HOBBIES, 1, "Hobbies Quiz", "This quiz tests your hobbies preferences");

        Question question1 = new Question(1, 1, "Do you like sport?", false);
        question1.addOption(new Option(1, 1, "Yes"));
        question1.addOption(new Option(2, 2, "No"));
        quiz.addQuestion(question1);

        Question question2 = new Question(2, 2, "What genre of music do you like?", true);
        question2.addOption(new Option(3, 1, "Rock"));
        question2.addOption(new Option(4, 2, "Pop"));
        question2.addOption(new Option(5, 3, "Metal"));
        question2.addOption(new Option(6, 4, "Classic"));
        question2.addOption(new Option(7, 5, "Jazz"));
        quiz.addQuestion(question2);

        return quiz;
    }

    public static Quiz createIqQuiz() {
        Quiz quiz = new Quiz(QuizType.IQ, 2, "IQ Quiz", "This quiz tests your IQ level");
        Question question1 = new Question(1,1,"how much is 2+2 ?", false);
        question1.addOption(new Option(1,1,"0"));
        question1.addOption(new Option(2,2,"4"));
        question1.addOption(new Option(3,3,"2"));
        question1.addOption(new Option(4,4,"8"));
        return quiz;
    }

    public static Quiz createPoliticalQuiz() {
        return new Quiz(QuizType.POLITICAL, 3, "Political Quiz", "This quiz tests your political preferences");
    }

    public static Quiz createPsychologicalQuiz() {
        return new Quiz(QuizType.PSYCHOLOGICAL, 4, "Psychological Quiz", "This quiz tests your Psychological type");
    }

    public static Quiz createReligionQuiz() {
        return new Quiz(QuizType.RELIGION, 5 , "Religion Quiz", "This quiz tests your religion preferences");
    }

    public static Optional<Quiz> create(QuizType type) {
        Quiz quiz;
        switch (type){
            case HOBBIES: quiz = createHobbieQuiz();
                break;
            case IQ: quiz = createIqQuiz();
                break;
            case POLITICAL: quiz = createPoliticalQuiz();
                break;
            case PSYCHOLOGICAL: quiz = createPsychologicalQuiz();
                break;
            case RELIGION: quiz = createReligionQuiz();
                break;
            default: quiz = null;
                break;
        }
        return Optional.of(quiz);
    }

}


