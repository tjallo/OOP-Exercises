package quiz;

public class Question {

    private String question;
    private String correctAnswer;
    private int score;

    public Question(String question, String answer) {
        this.question = question;
        this.correctAnswer = answer;
        this.score = 3;
    }

    public Question(String question, String answer, int score) {
        this.question = question;
        this.correctAnswer = answer;
        this.score = score;
    }

    @Override
    public String toString() {
        return question;
    }

    public boolean isCorrect(String answer) {
        return answer.equals(correctAnswer);
    }

    public String correctAnswer() {
        return correctAnswer;
    }

    public int getScore() {
        return score;
    }
}
