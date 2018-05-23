package algorithms;

/**
 * Iterative implementation of Binary Search
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {2, 4, 8, 10, 55, 76, 365, 900};
        int searchedValue = 10;

        System.out.println(binarySearch(searchedValue, array));
    }

    private static int binarySearch(int target, int[] array) {
        int left_idx = 0;
        int right_idx = array.length - 1;

        while (left_idx < right_idx){
            int middle = (left_idx + right_idx) / 2;
            if (target == array[middle]){
                return middle;
            } else if (target < array[middle]){
                right_idx = middle;
            } else {
                left_idx = middle;
            }
        }
        return -1;
    }
}
