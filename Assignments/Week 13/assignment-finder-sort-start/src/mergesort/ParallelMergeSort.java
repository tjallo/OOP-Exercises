package mergesort;

import java.util.Arrays;

public class ParallelMergeSort {

    public static void sort(int[] array) {
        final int treshold = 2500;

        // Sequential Sort
        if (array.length < treshold && array.length > 1) {
            int[] firstHalf = Arrays.copyOf(array, array.length / 2);
            sort(firstHalf);
            int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);
            sort(secondHalf);
            merge(firstHalf, secondHalf, array);
        } else if (array.length > 1) {
            int[] firstHalf = Arrays.copyOf(array, array.length / 2);
            int[] secondHalf = Arrays.copyOfRange(array, array.length / 2, array.length);

            Runnable half1 = () -> {
                sort(firstHalf);
            };

            Runnable half2 = () -> {
                sort(secondHalf);
            };
            Thread thread1 = new Thread(half1);
            Thread thread2 = new Thread(half2);
            thread1.start();
            thread2.start();

            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            merge(firstHalf, secondHalf, array);

        }

    };

    /**
     * merge two sorted arrays: O(N)
     * 
     * @param part1 a sorted array
     * @param part2 a sorted array
     * @param dest  destination, length must be >= part1.length + part2.length
     */
    public static void merge(int[] part1, int[] part2, int dest[]) {
        int part1Index = 0, part2Index = 0, destIndex = 0;
        while (part1Index < part1.length && part2Index < part2.length) {
            if (part1[part1Index] < part2[part2Index])
                dest[destIndex++] = part1[part1Index++];
            else
                dest[destIndex++] = part2[part2Index++];
        }
        // copy elements when at most one of the parts contains elements
        while (part1Index < part1.length)
            dest[destIndex++] = part1[part1Index++];
        while (part2Index < part2.length)
            dest[destIndex++] = part2[part2Index++];
    }

}
