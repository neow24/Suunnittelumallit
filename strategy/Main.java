package strategy;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int smallSize = 30;
        int largeSize = 100000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        Sorter sorter = new Sorter();
        SortingStrategy[] strategies = {
            new BubbleSort(),
            new QuickSort(),
            new MergeSort()
        };
        String[] strategyNames = {
            "Bubble Sort",
            "Quick  Sort",
            "Merge  Sort"
        };

        for (int i = 0; i < 3; i++) {
            int[] arrCopy = smallArray.clone();
            sorter.setStrategy(strategies[i]);

            long start = System.nanoTime();
            sorter.sort(arrCopy);
            long end = System.nanoTime();

            System.out.println(strategyNames[i] + " took " + (end - start) + " ns");
        }

        for (int i = 0; i < strategies.length; i++) {
            int[] arrCopy = largeArray.clone();
            sorter.setStrategy(strategies[i]);

            long start = System.nanoTime();
            sorter.sort(arrCopy);
            long end = System.nanoTime();

            System.out.println(strategyNames[i] + " took " + (end - start) + " ms");
        }
    }

    private static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }
}
