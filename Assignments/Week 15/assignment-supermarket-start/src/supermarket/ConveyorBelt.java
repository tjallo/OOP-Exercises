package supermarket;

public class ConveyorBelt {

	private final int[] elements;
	private int amount, begin, end;

	public ConveyorBelt(int size) {
		elements = new int[size];
		amount = 0;
		begin = 0;
		end = 0;
	}

	public void putIn(int item) {
		elements[end] = item;
		end = (end + 1) % elements.length;
		amount = amount + 1;
	}

	public int removeFrom() { // Assumes there is at least one element
		int item = elements[begin];
		begin = (begin + 1) % elements.length;
		amount = amount - 1;
		return item;
	}
}
