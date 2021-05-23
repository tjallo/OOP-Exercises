/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mergesort;

import java.util.Arrays;

public class Main {

  /**
   * 
   * 12 Cores Available (I assume Java only sees threads, not logical cores, I
   * know for a fact that I have 6 cores / 12 threads)
   * 
   * 
   * 
   * 
   * Program output:
   * 
   * sequential sort: 2096 millis. Array is sorted = true
   * 
   * parrallel sort: 648 millis. Array is sorted = true sorter arrays equals =
   * true
   * 
   * The number of processors is 12
   */

  private static final int L = 10000000;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    // Bit of Code I used to find a better treshold, since my first results varied a
    // lot.
    // int best_treshold = optimizer();
    // System.out.println(best_treshold);

    long time1, time2;
    int[] a1 = new int[L];
    int[] a2 = new int[L];
    for (int i = 0; i < L; i += 1) {
      a1[i] = a2[i] = (int) (Math.random() * L);
    }
    System.out.print("sequential sort: ");
    time1 = System.currentTimeMillis();
    MergeSort.sort(a1);
    time2 = System.currentTimeMillis();
    System.out.println((time2 - time1) + " millis. Array is sorted = " + MergeSort.isSorted(a1));

    System.out.print("parrallel sort: ");
    time1 = System.currentTimeMillis();
    // Use treshold parameter to set variable treshold, might vary per CPU
    ParallelMergeSort.sort(a2, 920000);
    time2 = System.currentTimeMillis();
    System.out.println((time2 - time1) + " millis. Array is sorted = " + MergeSort.isSorted(a2));
    System.out.println("sorter arrays equals = " + Arrays.equals(a1, a2));
    System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors());
  }

  private static int optimizer() {
    /**
     * Simple naive optimizer written to find an optimal treshold
     * 
     * @returns bestTreshold
     */
    long time1, time2;
    int[] a1 = new int[L];
    int[] a2 = new int[L];
    for (int i = 0; i < L; i += 1) {
      a1[i] = a2[i] = (int) (Math.random() * L);
    }

    long bestTime = 2000000000;
    int bestTreshold = 10000;

    // Change parameters here to find a better treshold
    for (int currentTreshold = bestTreshold; currentTreshold <= 5000000; currentTreshold = currentTreshold + 10000) {
      time1 = System.currentTimeMillis();
      ParallelMergeSort.sort(a2, currentTreshold);
      time2 = System.currentTimeMillis();

      long delta = time2 - time1;
      System.out.println((delta) + " millis. For array: " + Integer.toString(currentTreshold));

      if (delta < bestTime) {
        bestTime = delta;
        bestTreshold = currentTreshold;
      }
    }

    System.out.println("\n\n\n\n\n\nBest time was: " + bestTime);
    return bestTreshold;
  }
}
