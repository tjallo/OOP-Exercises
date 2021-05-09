package slidingGame;

import java.util.*;

/**
 * A class that implements a breadth-first search algorithm for finding the
 * Configurations for which the isSolution predicate holds
 */
public class Solver {
	// A queue for maintaining states that are not visited yet.
	private Queue<Configuration> toExamine;
	// A collection of states that have been visited
	private Collection<Configuration> encountered;

	public Solver(Configuration g) {
		toExamine = new PriorityQueue<>();
		encountered = new HashSet<>();
		toExamine.add(g);
		encountered.add(g);
	}

	/**
	 * A skeleton implementation of the solver
	 *
	 * @return a string representation of the solution
	 */
	public String solve() {
		while (!toExamine.isEmpty()) {
			Configuration next = toExamine.remove();
			if (next.isSolution()) {
				return printSolution(next);
			} else {
				for (Configuration succ : next.successors()) {
					if (!encountered.contains(succ)) {
						toExamine.add(succ);
						encountered.add(succ);
					}
				}
			}
		}
		return "This is an unsolvable game";
	}

	public String printSolution(Configuration next) {
		StringBuilder strBldr = new StringBuilder();
		for (Configuration c : next.pathFromRoot()) {
			strBldr.append(c);
			strBldr.append('\n');
		}
		return strBldr.toString();
	}

}