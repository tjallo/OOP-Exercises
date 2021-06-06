package supermarket;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Register {

	private static final int CONVEYER_SIZE = 10, BIN_SIZE = 10;
	private ConveyorBelt<Item> conveyorBelt;
	private ConveyorBelt<Item> conveyorBin;
	private Lock lock;

	public Register (){
		this.conveyorBelt = new ConveyorBelt(CONVEYER_SIZE);
		this.conveyorBin = new ConveyorBelt(BIN_SIZE);
		this.lock = new ReentrantLock();
	}


	public void putOnBelt(Item article) throws InterruptedException {
		conveyorBelt.putIn(article);

	}

	public Item removeFromBelt() throws InterruptedException {
		return conveyorBelt.removeFrom();
	}

	public void putInBin(Item article) throws InterruptedException {
		conveyorBin.putIn(article);
	}

	public Item removeFromBin() throws InterruptedException {
		return conveyorBin.removeFrom();
	}

	public void claim() {
		lock.lock();
	}

	public void free() {
		lock.unlock();
	}
}
