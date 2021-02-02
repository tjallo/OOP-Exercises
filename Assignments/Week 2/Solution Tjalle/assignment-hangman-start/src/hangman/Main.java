package hangman;

public class Main {
	public static void main(String[] args) {
		WordReader file = new WordReader("words.txt");
		String word = file.getWord();
		// System.out.println(word);

		Gallows gallow = new Gallows(word);

		gallow.printWord();
		gallow.guessLetter('a');
		gallow.guessLetter('e');
		System.out.println(gallow.getWordSoFar());
	}
}
