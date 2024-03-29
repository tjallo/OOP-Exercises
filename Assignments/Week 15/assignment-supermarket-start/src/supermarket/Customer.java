package supermarket;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Customer implements Callable<Integer> {

	public static final int MAX_ITEMS = 20;
	private final Store store;
	private final int customerNumber;
	private final int numberOfItemsWanted;
	private final static Random GENERATOR = new Random();

	public int getNumberOfItemsWanted() {
		return numberOfItemsWanted;
	}

	public Customer(int number, Store store) {
		this.store = store;
		customerNumber = number;
		numberOfItemsWanted = GENERATOR.nextInt(MAX_ITEMS) + 1;
	}

	@Override
	public Integer call() {
		int numberOfItemsBought = 0;
		List<Item> wanted = store.getItems(numberOfItemsWanted);

		final int registerNumber = GENERATOR.nextInt(store.NUMBER_OF_CHECKOUTS);
		Register register = store.claimRegister(registerNumber);
		register.claim();

		try {
			for (Item i : wanted) {
				register.putOnBelt(i);
			}

			while (register.removeFromBin() != null) {
				numberOfItemsBought++;
			}
		} catch (InterruptedException e) {
			numberOfItemsBought = 0;
			e.printStackTrace();
		}
		register.free();

		return numberOfItemsBought;

	}
}
