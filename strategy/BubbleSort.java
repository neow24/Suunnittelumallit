package strategy;

// https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/

public class BubbleSort implements SortingStrategy {
    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        // boolean swapped;
        for (int i = 0; i < length - 1; i++) {
            // swapped = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // swapped = true;
                }
            }

            // if (swapped == false) break;
        }
    }

    // static void printArray(int arr[], int size){
    //     int i;
    //     for (i = 0; i < size; i++)
    //         System.out.print(arr[i] + " ");
    //     System.out.println();
    // }
}
