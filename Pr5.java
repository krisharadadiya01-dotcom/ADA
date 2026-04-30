import java.util.Random;

public class QuickSortPerformance {

    // Quick Sort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // Partition index
            int pi = partition(arr, low, high);

            // Sort left part
            quickSort(arr, low, pi - 1);

            // Sort right part
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method
    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // Last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int size = 100000; // Large dataset size
        int[] data = new int[size];

        Random random = new Random();

        // Generate random numbers
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(100000);
        }

        // Start time
        long startTime = System.nanoTime();

        // Perform Quick Sort
        quickSort(data, 0, data.length - 1);

        // End time
        long endTime = System.nanoTime();

        // Calculate execution time
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
