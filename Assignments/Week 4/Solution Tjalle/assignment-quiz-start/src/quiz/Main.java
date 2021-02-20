package quiz;

public class Main {

	public static void main(String[] args) {

		Question q = new ThisThatQuestion("Are you hungry?", "yes", "no", 0, 1);

		System.out.println(q.isCorrect("yes"));
	}

}