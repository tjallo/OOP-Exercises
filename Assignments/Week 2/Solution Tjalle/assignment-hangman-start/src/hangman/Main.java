package hangman;

public class Main {
	public static void main(String[] args) {
		WordReader file = new WordReader("words.txt");
		String word = file.getWord();
		// System.out.println(word);

		GallowsUI game = new GallowsUI();

		game.Play();

	}
}
