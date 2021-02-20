package quiz;

public class Main {

	public static void main(String[] args) {

		Question q = new MultipleChoiceQuestion("What is the complexity of making pancakes?",
				new String[] { "O(N)", "O(log N)", "O(N log N)" }, 1, 4);

		System.out.println(q.toString());

		System.out.println("What is the complexity of making pancakes?\na) O(N)\nb) O(log N)\nc) O(N log N)\n");
	}

}