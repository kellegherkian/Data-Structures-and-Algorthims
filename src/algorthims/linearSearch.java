package algorthims;

import java.util.ArrayList;
import java.util.List;

public class linearSearch {
    // Method to perform linear search and return the index of the first occurrence
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;  // Target found at index i
            }
        }
        return -1;  // Target not found
    }

    // Method to perform linear search and return a list of all occurrences
    public static List<Integer> linearSearchAll(int[] array, int target) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                indices.add(i);  // Add the index of the target
            }
        }
        return indices;
    }

    // Method to perform linear search within a specific range
    public static int linearSearchInRange(int[] array, int target, int start, int end) {
        if (start < 0 || end >= array.length || start > end) {
            throw new IllegalArgumentException("Invalid range specified.");
        }
        for (int i = start; i <= end; i++) {
            if (array[i] == target) {
                return i;  // Target found at index i
            }
        }
        return -1;  // Target not found
    }

    // Method to search and return detailed results
    public static SearchResult linearSearchDetailed(int[] array, int target) {
        SearchResult result = new SearchResult();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result.firstOccurrence = i;
                result.allOccurrences.add(i);
            }
        }
        if (result.allOccurrences.isEmpty()) {
            result.firstOccurrence = -1;  // Target not found
        }
        return result;
    }

    // Demo method to showcase enhanced linear search
    public static void demo() {
        int[] array = {1, 3, 5, 3, 7, 9, 3, 11, 13, 3};
        int target = 3;

        System.out.println("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Perform simple linear search
        int firstIndex = linearSearch(array, target);
        System.out.println("First occurrence of " + target + ": " + (firstIndex != -1 ? "Found at index " + firstIndex : "Not found"));

        // Perform linear search to find all occurrences
        List<Integer> allIndices = linearSearchAll(array, target);
        System.out.println("All occurrences of " + target + ": " + allIndices);

        // Perform linear search within a specific range
        int rangeStart = 2;
        int rangeEnd = 6;
        int rangeIndex = linearSearchInRange(array, target, rangeStart, rangeEnd);
        System.out.println("Occurrence of " + target + " in range [" + rangeStart + ", " + rangeEnd + "]: " + (rangeIndex != -1 ? "Found at index " + rangeIndex : "Not found"));

        // Perform detailed linear search
        SearchResult detailedResult = linearSearchDetailed(array, target);
        System.out.println("Detailed search result for " + target + ":");
        System.out.println("First occurrence: " + detailedResult.firstOccurrence);
        System.out.println("All occurrences: " + detailedResult.allOccurrences);
    }

    // Class to hold detailed search results
    public static class SearchResult {
        public int firstOccurrence;
        public List<Integer> allOccurrences;

        public SearchResult() {
            this.firstOccurrence = -1;
            this.allOccurrences = new ArrayList<>();
        }
    }
}