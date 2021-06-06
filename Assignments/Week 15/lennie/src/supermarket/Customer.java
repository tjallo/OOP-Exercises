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
		try {
			List<Item> wantedList = store.getItems(numberOfItemsWanted);
			Register register = store.claimRegister(new Random().nextInt(Store.NUMBER_OF_CHECKOUTS));
			register.claim();
			int numberOfItemsBought = 0;
			for (Item item : wantedList) {
				register.putOnBelt(item);
			}
			register.putOnBelt(null);
			while (register.removeFromBin() != null){
				numberOfItemsBought++;
			}
			register.free();
			return numberOfItemsBought;
		}
		catch (InterruptedException interruptedException){
			return 0;
		}
	}
}
