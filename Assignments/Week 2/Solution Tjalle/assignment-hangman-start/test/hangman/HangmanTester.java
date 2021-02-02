package hangman;

public class HangmanTester {

	private Gallows gallow;

	public void newGallows(String word) {
		gallow = new Gallows(word);
	}

	public String getWordSoFar() {
		return gallow.getWordSoFar();
	}

	public void guessLetter(char c) {
		gallow.guessLetter(c);
	}

	public String getGuessedLetters() {
		return gallow.getGuessedLetters();
	}
	
	public boolean isWordGuessed() {
		return gallow.isWordGuessed();
	}
}
