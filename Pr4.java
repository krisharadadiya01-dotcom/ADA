import java.util.Random;

public class MergeSortPerformance {

    // Merge Sort method
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort left half
            mergeSort(arr, left, mid);

            // Sort right half
            mergeSort(arr, mid + 1, right);

            // Merge sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge method
    public static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        // Merge arrays
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
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

        // Perform Merge Sort
        mergeSort(data, 0, data.length - 1);

        // End time
        long endTime = System.nanoTime();

        // Calculate execution time
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("Execution Time: " + executionTime + " ms");
    }
}
