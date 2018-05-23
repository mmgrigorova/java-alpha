package algorithms;

/**
 * Recursive implementation of Binary Search for practice
 */

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] array = {2, 4, 8, 10, 55, 76, 365, 900};
        int searchedValue = 11;

        System.out.println(binarySearch(searchedValue, array, 0, array.length - 1));
    }

    private static int binarySearch(int target, int[] array, int left_idx, int right_idx) {
        if (left_idx >= right_idx && array[left_idx] != target) {
            return -1;
        }

        int middle = (left_idx + right_idx) / 2;
        if (target == array[middle]) {
            return middle;
        } else if (target < array[middle]) {
            return binarySearch(target, array, left_idx, middle);
        } else {
            return binarySearch(target, array, middle + 1, right_idx);
        }
    }
}
