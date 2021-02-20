package quiz;

public class Question {

    protected String question;
    protected String correctAnswer;
    private int score;

    public Question(String question, String answer) {
        this.question = question;
        this.correctAnswer = answer;
        this.score = 3;
    }

    public Question(String question, String answer, int score) {
        this.question = question;
        this.correctAnswer = answer;
        if (score >= 0 && score <= 6) {
            this.score = score;
        } else {
            this.score = 3;
        }
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
