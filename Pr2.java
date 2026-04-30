import java.util.Random;

public class BubbleSortPerformance {

    // Bubble Sort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop if already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset size
        int[] data = new int[size];

        Random random = new Random();

        // Generate random numbers
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(100000);
        }

        // Start time
        long startTime = System.nanoTime();

        // Perform Bubble Sort
        bubbleSort(data);

        // End time
        long endTime = System.nanoTime();

        // Calculate execution time
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
