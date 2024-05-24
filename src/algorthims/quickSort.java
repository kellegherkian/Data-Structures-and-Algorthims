package algorthims;

import java.util.Arrays;

public class quickSort {
    // Method to perform quick sort
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low + 10 <= high) { // Use insertion sort for small arrays
            int pivot = medianOfThree(array, low, high);
            int partitionPoint = partition(array, low, high, pivot);
            quickSort(array, low, partitionPoint - 1);
            quickSort(array, partitionPoint + 1, high);
        } else {
            insertionSort(array, low, high);
        }
    }

    private static int medianOfThree(int[] array, int low, int high) {
        int mid = (low + high) / 2;
        if (array[low] > array[mid]) {
            swap(array, low, mid);
        }
        if (array[low] > array[high]) {
            swap(array, low, high);
        }
        if (array[mid] > array[high]) {
            swap(array, mid, high);
        }
        swap(array, mid, high - 1); // Place pivot at high - 1
        return array[high - 1];
    }

    private static int partition(int[] array, int low, int high, int pivot) {
        int i = low;
        int j = high - 1;

        while (true) {
            while (array[++i] < pivot) {}
            while (array[--j] > pivot) {}
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, i, high - 1); // Restore pivot
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void insertionSort(int[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= low && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Demo method to showcase quick sort
    public static void demo() {
        int[] array = {29, 10, 14, 37, 13, 19, 27, 42, 8, 39};
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
