package quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Question> questions = new LinkedList<>();
    private List<Question> wrongAnsweredQuestions = new LinkedList<>();
    private int score;
    private Scanner scanner = new Scanner(System.in);

    public Game() {
        addQuestions();
    }

    public void addQuestions() {
        questions.add(new OpenQuestion("What is the big O complexity of binary search?", "O(log N)"));

        // questions.add(
        // new OpenQuestion("How would you read an integer i from scanner s in Java?",
        // "i = s.nextInt();", 2));

        // questions.add(new OpenQuestion(
        // "What is the minimum amount of constructors you have to define for a class in
        // Java?", "0", 2));

        questions.add(new MultipleChoiceQuestion("What is the best achievable complexity of in situ sorting?",
                new String[] { "O(N^2)", "O(N log N)", "O(N)", "O(log N)" }, 1, 4));

        questions.add(new MultipleChoiceQuestion("How do you print \"Hello world\" on a line in Java?",
                new String[] { "System.out.print(\"Hello world\");", "System.out.println(\"Hello world\");",
                        "cout << \"Hello world\";" },
                1));

        questions.add(new MultipleChoiceQuestion("How do you read a non-empty word in Java using scanner s?",
                new String[] { "s.nextline()", "s.next(\"\\S+\")", "s.next(\"\\a*\")", "s.next(\"\\S*\")",
                        "s.next(\"\\\\s+\")", "s.next(\"\\s+\")", "s.nextString(\"\\s*\")", "s.next(\"\\\\S+\")",
                        "s.nextString()" },
                7, 1));

        // questions.add(new ThisThatQuestion("Every class must have a constructor",
        // "Right", "Wrong", 1));

        questions.add(new ThisThatQuestion("Is there a difference between an interface and an abstract class?", "Yes",
                "No", 0, 5));

        // questions.add(new ThisThatQuestion("Is there a maximum to the amount of
        // constructors a class can have in Java?",
        // "Yes", "No", 1));
    }

    public void play() {
        firstRound();
        secondRound();
    }

    public void firstRound() {
        while (questions.size() > 0) {
            Question q = questions.get(0);

            System.out.println(q.toString());

            checkAnswer(scanner.nextLine(), q, true);

            questions.remove(0);
        }
    }

    public void secondRound() {
        while (wrongAnsweredQuestions.size() > 0) {
            Question q = wrongAnsweredQuestions.get(0);

            System.out.println(q.toString());

            checkAnswer(scanner.nextLine(), q, false);

            wrongAnsweredQuestions.remove(0);
        }

        System.out.println(
                "You have completed the two rounds of questions!\nYour final score is: " + Integer.toString(score));
    }

    public void checkAnswer(String answer, Question q, boolean addToWrong) {
        if (!q.isCorrect(answer) && addToWrong) {
            System.out.println("Your answer was wrong, the correct answer is: " + q.correctAnswer);
            wrongAnsweredQuestions.add(q);
        } else {
            System.out.println("Your answer was right!");
            score = score + q.getScore();
        }

        System.out.println("Your current score is: " + Integer.toString(score) + "\n");
    }
}
