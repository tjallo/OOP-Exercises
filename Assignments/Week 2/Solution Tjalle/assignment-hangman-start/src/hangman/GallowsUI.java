package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class GallowsUI {
    private int remainingMistakes = 10;
    private ArrayList<Character> guessedLetters;
    private String wordSoFar;
    private Gallows gallow;

    /**
     * Main interface; allows you to play the command line game
     */
    public void play() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Please enter a word or press Enter to randomly pick one");

        initWord(scanner.nextLine());

        while (!gallow.isWordGuessed() && remainingMistakes >= 0) {
            guessTry(scanner);
        }

        if (gallow.isWordGuessed()) {
            System.out.println("You have won!");
            System.out.println("The word was: " + gallow.getWord());
        } else {
            System.out.println("You have lost!");
            System.out.println("The word was: " + gallow.getWord());
        }

        scanner.close();
    }

    /**
     * Parses the input word of the user
     * 
     * @param wordIn
     * @return
     */
    private void initWord(String wordIn) {

        String word = wordIn;

        if (wordIn.equals("")) {
            System.out.println("Randomly picking a word.");
            WordReader file = new WordReader("words.txt");
            word = file.getWord();
        }

        gallow = new Gallows(word);
        guessedLetters = gallow.getGuessedLettersArrayList();
        wordSoFar = gallow.getWordSoFar();

    }

    private void guessTry(Scanner scanner) {

        printState();
        char guess = scanner.nextLine().charAt(0);
        gallow.guessLetter(guess);

        checkMistake(wordSoFar, gallow.getWordSoFar());

        guessedLetters = gallow.getGuessedLettersArrayList();
        wordSoFar = gallow.getWordSoFar();

    }

    private void checkMistake(String oldWord, String newWord) {
        if( oldWord.equals(newWord)){
            remainingMistakes--;
        }
    }

    /**
     * Prints current state of the game
     */
    private void printState() {
        System.out.println("Remaining mistakes: " + Integer.toString(remainingMistakes));
        System.out.println("Guessed letters: " + guessedLetters.toString());
        System.out.println("Word: " + wordSoFar);
    }

}
