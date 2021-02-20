package quiz;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private List<Question> questions = new LinkedList<>();
    private List<Question> wrongAnswered = new LinkedList<>();

    public Game() {
        questions.add(new OpenQuestion("What is the big O complexity of binary search?", "O(log N)"));
        questions.add(
                new OpenQuestion("How would you read an integer i from scanner s in Java?", "i = s.nextInt();", 2));
        questions.add(new OpenQuestion(
                "What is the minimum amount of constructors you have to define for a class in Java?", "0", 2));
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
        questions.add(new ThisThatQuestion("Every class must have a constructor", "Right", "Wrong", 1));
        questions.add(new ThisThatQuestion("Is there a difference between an interface and an abstract class?", "Yes",
                "No", 0, 5));
        questions.add(new ThisThatQuestion("Is there a maximum to the amount of constructors a class can have in Java?",
                "Yes", "No", 1));
    }

    

}
