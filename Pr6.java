import java.util.Arrays;

public class SearchAlgorithms {

    // Linear Search method
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Element found
            }
        }
        return -1; // Element not found
    }

    // Binary Search method
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid; // Element found
            } else if (arr[mid] < key) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Element not found
    }

    public static void main(String[] args) {

        int[] data = {45, 12, 78, 34, 23, 89, 67};
        int key = 34;

        // Linear Search
        int linearResult = linearSearch(data, key);

        if (linearResult != -1) {
            System.out.println("Linear Search: Element found at index " + linearResult);
        } else {
            System.out.println("Linear Search: Element not found");
        }

        // Binary Search requires sorted array
        Arrays.sort(data);

        int binaryResult = binarySearch(data, key);

        if (binaryResult != -1) {
            System.out.println("Binary Search: Element found at index " + binaryResult);
        } else {
            System.out.println("Binary Search: Element not found");
        }
    }
}
