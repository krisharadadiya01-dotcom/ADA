import java.util.Random;

public class SelectionSortPerformance {

    // Selection Sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find minimum element in unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap minimum element with first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

        // Perform Selection Sort
        selectionSort(data);

        // End time
        long endTime = System.nanoTime();

        // Calculate execution time
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
