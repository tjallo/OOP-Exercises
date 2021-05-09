package slidingGame;

import java.util.Collection;
import java.util.LinkedList;

/**
 * A template of a sliding game
 */
public class SlidingGame implements Configuration {

	public static final int N = 3, SIZE = N * N, HOLE = SIZE;
	/**
	 * The board is represented by a 2-dimensional array; the position of the hole
	 * is kept in 2 variables holeX and holeY
	 */
	private int[][] board;
	private int holeX, holeY;
	private int mhtDist = 1337;
	private Configuration predecessor;

	/**
	 * A constructor that initializes the board with the specified array
	 *
	 * @param start: a one dimensional array containing the initial board. The
	 *               elements of start are stored row-wise.
	 */
	public SlidingGame(int[] start) {
		board = new int[N][N];

		assert start.length == N * N : "Length of specified board incorrect";

		for (int p = 0; p < start.length; p++) {
			board[p % N][p / N] = start[p];
			if (start[p] == HOLE) {
				holeX = p % N;
				holeY = p / N;
			}
		}
	}

	public int calculateManhattanDist() {
		mhtDist = 0;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (board[y][x] != HOLE) {
					int finalY = (board[y][x] - 1) / N;
					int finalX = (board[y][x] - 1) % N;

					mhtDist += Math.abs(x - finalY);
					mhtDist += Math.abs(y - finalX);
				}
			}
		}
		return mhtDist;
	}

	public int getManhattanDistance() {
		return calculateManhattanDist();
	}

	/**
	 * Converts a board into a printable representation. The hole is displayed as a
	 * space
	 *
	 * @return the string representation
	 */
	@Override
	public String toString() {
		StringBuilder bufBldr = new StringBuilder();
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				int puzzle = board[y][x];
				bufBldr.append(puzzle == HOLE ? "  " : puzzle + " ");
			}
			bufBldr.append("\n");
		}
		return bufBldr.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o.getClass() == this.getClass()) {
			SlidingGame a = (SlidingGame) o;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (board[y][x] != a.board[y][x]) {
						return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isSolution() {
		int expVal = 1;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (board[y][x] != expVal) {
					return false;
				}
				expVal += 1;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (int x = N - 1; x >= 0; x--) {
			for (int y = N - 1; y >= 0; y--) {
				hash = 31 * hash + board[x][y];
			}
		}
		return hash;
	}

	@Override
	public Collection<Configuration> successors() {
		LinkedList<Configuration> linkedList = new LinkedList<>();
		for (Direction d : Direction.values()) {
			int newX = holeX + d.getDX();
			int newY = holeY + d.getDY();
			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				SlidingGame sldGame = new SlidingGame(this, d);
				linkedList.add(sldGame);
			}
		}
		return linkedList;
	}

	public SlidingGame(SlidingGame parent, Direction direction) {
		predecessor = parent;
		board = new int[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				board[y][x] = parent.board[y][x];
			}
		}
		holeX = parent.holeX + direction.getDX();
		holeY = parent.holeY + direction.getDY();

		board[parent.holeX][parent.holeY] = board[parent.holeX + direction.getDX()][parent.holeY + direction.getDY()];

		board[holeX][holeY] = HOLE;
	}

	@Override
	public int compareTo(Configuration g) {
		return calculateManhattanDist() - ((SlidingGame) g).calculateManhattanDist();
	}

	@Override
	public Configuration getParent() {
		return predecessor;
	}

}