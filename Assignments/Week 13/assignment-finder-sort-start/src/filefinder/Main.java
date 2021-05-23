package filefinder;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			String goal = "needle.txt";
			String root = "haystack";
			// FileFinder ff = new FileFinder(root);
			// ff.findFile(goal);
			ThreadedFileFinder tff = new ThreadedFileFinder(root, goal);
			tff.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
