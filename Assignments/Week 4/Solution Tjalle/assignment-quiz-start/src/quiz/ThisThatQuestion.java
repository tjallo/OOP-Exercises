package quiz;

public class ThisThatQuestion extends MultipleChoiceQuestion {

    public ThisThatQuestion(String question, String answer1, String answer2, int correctAnswer, int score) {
        super(question, new String[] { answer1, answer2 }, correctAnswer, score);
    }

    public ThisThatQuestion(String question, String answer1, String answer2, int correctAnswer) {
        super(question, new String[] { answer1, answer2 }, correctAnswer);
    }

    @Override
    public String toString() {
        return answers[0] + " or " + answers[1] + ": " + question;
    }

    @Override
    public boolean isCorrect(String answer) {
        return correctAnswer.equals(answer);
    }

    @Override
    public String correctAnswer() {
        return correctAnswer;
    }
}
