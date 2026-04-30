import java.util.Random;

public class InsertionSortPerformance {

    // Insertion Sort method
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move larger elements one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at correct position
            arr[j + 1] = key;
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

        // Perform Insertion Sort
        insertionSort(data);

        // End time
        long endTime = System.nanoTime();

        // Calculate execution time
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
