package supermarket;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	// Made by Max Loeffen s1053029 and Lennart Heijmans s1053872

	private static final int NR_OF_CLIENTS = 100;

	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Store store = new Store(executor);

		List<Future<Void>> cashiers = store.open();

		List<Customer> customers = IntStream.range(0, NR_OF_CLIENTS).mapToObj(i -> new Customer(i, store))
				.collect(Collectors.toList());
		List<Future<Integer>> customerResults = executor.invokeAll(customers);
		int totalItemsSold = 0;
		for (Future<Integer> customer : customerResults) {
			try {
				totalItemsSold += customer.get();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		int totalItemsWanted = customers.stream().mapToInt(Customer::getNumberOfItemsWanted).sum();
		System.out.println("All customers are done.");
		System.out.println(totalItemsWanted + " items wanted.");
		System.out.println(totalItemsSold + " items sold.");
		cashiers.stream().forEach(i -> i.cancel(true));
		executor.shutdown();
	}
}
