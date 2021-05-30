package taxi;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Trains bring a number of passengers to a station in the Taxi simulation
 */
public class Train implements Runnable {
	private int nrOfPassengers;
	private final Station station;
	private int nrOfTrips = 0;

	public Train(Station station) {
		this.station = station;
		this.nrOfPassengers = 0;
	}

	/**
	 * Populate this train with number nrOfPassengers
	 *
	 * @param number the number of passengers of this train
	 */
	public void loadPassengers(int number) {
		nrOfPassengers = number;
	}

	/**
	 * empties this train and augment the number of Passengers at the station with
	 * this nrOfPassenegers
	 */
	public void unloadPassengers() {
		nrOfTrips += 1;
		station.enterStation(nrOfPassengers);

		try {
			TimeUnit.MILLISECONDS.sleep(Util.getRandomNumber(800, 1500));
		} catch (InterruptedException e) {
			Logger.getLogger(Train.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public void closeStation() {
		station.close();
	}

	public int getNrOfTrips() {
		return nrOfTrips;
	}

	public void run() {
		while (getNrOfTrips() < Simulation.TRAIN_TRIPS) {
			loadPassengers(Util.getRandomNumber(Simulation.MIN_TRAVELLERS, Simulation.MAX_TRAVELLERS));
			unloadPassengers();
		}
		station.close();
	}
}