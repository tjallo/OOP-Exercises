package taxi;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class that holds the number of persons arriving by train at the station and
 * waiting for a taxi
 */
public class Station {

	private int nrOfPassengersAtStation = 0;
	private int totalNrOfPassengers = 0;
	private boolean isClosed = false;
	private final Lock reLock = new ReentrantLock();

	public void enterStation(int nrOfPassengers) {
		nrOfPassengersAtStation += nrOfPassengers;
		totalNrOfPassengers += nrOfPassengers;
		System.out.println(nrOfPassengers + " passengers arrived at station");
	}

	/**
	 * Ask for nrOfPassengers Passengers to leave the station
	 *
	 * @param requestedNrOfPassengers
	 * @return number of passengers actually leaving
	 */
	public int leaveStation(int requestedNrOfPassengers) {
		int actuallyLeaving = Math.min(requestedNrOfPassengers, nrOfPassengersAtStation);
		nrOfPassengersAtStation -= actuallyLeaving;
		return actuallyLeaving;
	}

	public int waitingPassengers() {
		reLock.lock();
		try {
			return nrOfPassengersAtStation;
		} finally {
			reLock.unlock();
		}
	}

	public void close() {
		isClosed = true;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public int getTotalNrOfPassengers() {
		return totalNrOfPassengers;
	}
}