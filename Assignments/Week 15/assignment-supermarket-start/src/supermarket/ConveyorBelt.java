package supermarket;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConveyorBelt<T> {

	private final T[] elements;
	private int amount, begin, end;

	private final Lock lock = new ReentrantLock();

	private final Condition inCondition = lock.newCondition();
	private final Condition outCondition = lock.newCondition();

	public ConveyorBelt(int size) {
		elements = (T[]) new Object[size];
		amount = 0;
		begin = 0;
		end = 0;
	}

	public void putIn(T item) throws InterruptedException {
		lock.lock();

		try {

			while (elements.length == amount) {
				inCondition.await();
			}

			elements[end] = item;
			end = (end + 1) % elements.length;
			amount = amount + 1;

		} finally {

			lock.unlock();

		}

	}

	public Object removeFrom() throws InterruptedException {

		T item;

		lock.lock();

		try {

			while (amount <= 0) {
				outCondition.await();
			}

			item = elements[begin];
			begin = (begin + 1) % elements.length;
			amount = amount - 1;
			return item;

		} finally {

			lock.unlock();

		}

	}
}
