package hangman;

import java.util.Scanner;

public class GallowsUI {

    public void Play() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Hangman!");
        System.out.println("Please enter a word or press Enter to randomly pick one");
        String wordIn = scanner.nextLine();

        String word = getWord(wordIn);

        System.out.println(word);
        scanner.close();
    }

    private String getWord(String wordIn) {

        String word = wordIn;
        if (wordIn.equals("")) {
            System.out.println("Randomly picking a word.");
            WordReader file = new WordReader("words.txt");
            word = file.getWord();
        }

        return word;
    }


}
