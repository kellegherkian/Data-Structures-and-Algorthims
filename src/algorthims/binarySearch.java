package algorthims;

public class binarySearch {
    // Iterative approach to binary search
    public static int binarySearchIterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    // Recursive approach to binary search
    public static int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursiveHelper(array, target, 0, array.length - 1);
    }

    private static int binarySearchRecursiveHelper(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1; // Target not found
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        }

        if (array[mid] < target) {
            return binarySearchRecursiveHelper(array, target, mid + 1, right);
        } else {
            return binarySearchRecursiveHelper(array, target, left, mid - 1);
        }
    }

    // Find the first occurrence of the target value
    public static int findFirstOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                result = mid;
                right = mid - 1; // Move left to find the first occurrence
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Find the last occurrence of the target value
    public static int findLastOccurrence(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                result = mid;
                left = mid + 1; // Move right to find the last occurrence
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Count the total number of occurrences of the target value
    public static int countOccurrences(int[] array, int target) {
        int first = findFirstOccurrence(array, target);
        if (first == -1) {
            return 0; // Target not found
        }
        int last = findLastOccurrence(array, target);
        return last - first + 1;
    }

    // Perform binary search within a specific range
    public static int binarySearchInRange(int[] array, int target, int start, int end) {
        if (start < 0 || end >= array.length || start > end) {
            throw new IllegalArgumentException("Invalid range specified.");
        }

        int left = start;
        int right = end;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid;
            }

            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    // Demo method to showcase advanced binary search
    public static void demo() {
        int[] array = {1, 3, 5, 7, 7, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;

        System.out.println("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Iterative search
        int iterativeResult = binarySearchIterative(array, target);
        System.out.println("Iterative search for " + target + ": " + (iterativeResult != -1 ? "Found at index " + iterativeResult : "Not found"));

        // Recursive search
        int recursiveResult = binarySearchRecursive(array, target);
        System.out.println("Recursive search for " + target + ": " + (recursiveResult != -1 ? "Found at index " + recursiveResult : "Not found"));

        // First occurrence
        int firstOccurrence = findFirstOccurrence(array, target);
        System.out.println("First occurrence of " + target + ": " + (firstOccurrence != -1 ? "Found at index " + firstOccurrence : "Not found"));

        // Last occurrence
        int lastOccurrence = findLastOccurrence(array, target);
        System.out.println("Last occurrence of " + target + ": " + (lastOccurrence != -1 ? "Found at index " + lastOccurrence : "Not found"));

        // Count occurrences
        int count = countOccurrences(array, target);
        System.out.println("Total occurrences of " + target + ": " + count);

        // Search within a range
        int start = 2;
        int end = 6;
        int rangeResult = binarySearchInRange(array, target, start, end);
        System.out.println("Search for " + target + " in range [" + start + ", " + end + "]: " + (rangeResult != -1 ? "Found at index " + rangeResult : "Not found"));
    }
}