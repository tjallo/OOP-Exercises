package hangman;

import java.util.ArrayList;

public class Gallows {

    private final String word;
    private StringBuilder wordSoFar;
    private ArrayList<Character> guessedLetters = new ArrayList<Character>();

    public Gallows(String word) {
        this.word = word;
        this.wordSoFar = buildWordSoFar(this.word);
    }

    /**
     * Builds a string of dots according to the input word
     * 
     * @param word
     * @return
     */
    private StringBuilder buildWordSoFar(String word) {
        StringBuilder result = new StringBuilder("");

        for (int i = 0; i < word.length(); i++) {
            result.append('.');
        }

        return result;
    }

    /**
     * Prints (part of) the word that has been guessed so far
     */
    public String getWordSoFar() {
        return wordSoFar.toString();
    }

    /**
     * Prints the word that has to be guessed
     */
    public void printWord() {
        System.out.println(word);
    }

    /**
     * Allows you to guess a letter
     * 
     * @param c
     */
    public void guessLetter(char c) {

        ArrayList<Integer> indices = getStringindices(c);
        updateWordSoFar(indices, c);
        updateGuessedLetters(c);

    }

    /**
     * Get all indices of a char in a string
     * 
     * @return
     */
    private ArrayList<Integer> getStringindices(char c) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == c) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * Updates word so far according to list of indices and the char that has to be
     * placed at these indices
     * 
     * @param indices
     * @param c
     */
    private void updateWordSoFar(ArrayList<Integer> indices, char c) {

        for (int i : indices) {
            wordSoFar.setCharAt(i, c);
        }

    }

    /**
     * Update the guessed letters array with new character
     * 
     * @param c
     */
    private void updateGuessedLetters(char c) {
        if (!guessedLetters.contains(c)) {
            guessedLetters.add(c);
        }
    }

    /**
     * Get all the guessed letters as a String
     * 
     * @return
     */
    public String getGuessedLetters() {
        StringBuilder result = new StringBuilder("");

        for (char c : guessedLetters) {
            result.append(c);
        }

        return result.toString();
    }

    /**
     * Check wether word is guessed
     * 
     * @return Boolean
     */
    public boolean isWordGuessed() {
        return word.equals(wordSoFar.toString());
    }

}
