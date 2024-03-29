package supermarket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Register {

	// Make sure that CONVEYOR_SIZE + BIN_SIZE >= Customer.MAX_ITEMS, otherwise
	// danger of deadlock
	private static final int CONVEYER_SIZE = 10, BIN_SIZE = 10;

	private final Lock lock = new ReentrantLock();

	private final ConveyorBelt onBelt, outBin;

	public Register() {
		onBelt = new ConveyorBelt(CONVEYER_SIZE);
		outBin = new ConveyorBelt(BIN_SIZE);
		
	}

	public void putOnBelt(Item article) throws InterruptedException {
		onBelt.putIn(article);
	}

	public Item removeFromBelt() throws InterruptedException {
		return (Item) outBin.removeFrom();
	}

	public void putInBin(Item article) throws InterruptedException {
		outBin.putIn(article);
	}

	public Item removeFromBin() throws InterruptedException {
		return (Item) outBin.removeFrom();
	}

	public void claim() {
		lock.lock();
	}

	public void free() {
		lock.unlock();
	}
}
