package quiz;

public class MultipleChoiceQuestion extends Question {

    protected String[] answers;
    private String answerLetter;

    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer, int score) {
        super(question, answers[correctAnswer], score);
        this.answers = answers;
        // Converting from int to Ascii using offset to char and from char to String
        this.answerLetter = Character.toString((char)(correctAnswer + 97));
    }

    public MultipleChoiceQuestion(String question, String[] answers, int correctAnswer) {
        super(question, answers[correctAnswer]);
        this.answers = answers;
        // Converting from int to Ascii using offset to char and from char to String
        this.answerLetter = Character.toString((char)(correctAnswer + 97));
    }

    private String answerBuilder() {
        StringBuilder s = new StringBuilder("");

        for (int i = 0; i < answers.length; i++) {
            // Offset using Ascii to generate a), b) etc.
            char c = (char) (i + 97);
            s.append(c);
            s.append(") ");
            s.append(answers[i]);
            s.append("\n");
        }

        return s.toString();
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + answerBuilder();
    }

    @Override
    public boolean isCorrect(String answer) {
        // using ascii conversion to get answer place
        int pos = ((int) answer.charAt(0)) - 97;
        return super.isCorrect(answers[pos]);
    }

    @Override
    public String correctAnswer() {
        return answerLetter;
    }
}
