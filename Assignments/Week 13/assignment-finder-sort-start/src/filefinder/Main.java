package filefinder;

import java.io.IOException;

public class Main {
	/**
	 * 
	 * 12 Cores Available (I assume Java only sees threads, not logical cores, I
	 * know for a fact that I have 6 cores / 12 threads)
	 * 
	 * he sequential version took 1990 milliseconds.
	 * 
	 * The threaded version took 2 milliseconds.
	 */

	public static void main(String[] args) {
		try {
			String goal = "needle.txt";
			String root = "haystack";

			long start1 = System.currentTimeMillis();
			FileFinder ff = new FileFinder(root);
			ff.findFile(goal);
			long end1 = System.currentTimeMillis();

			System.out.println("The sequential version took " + Long.toString(end1 - start1) + " milliseconds.");

			long start2 = System.currentTimeMillis();
			ThreadedFileFinder tff = new ThreadedFileFinder(root, goal);
			tff.run();
			long end2 = System.currentTimeMillis();

			System.out.println("The threaded version took " + Long.toString(end2 - start2) + " milliseconds.");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
