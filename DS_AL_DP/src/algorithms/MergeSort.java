package algorithms;

/**
 * Recursive Merge Sort Implementation
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {5, 8, 50, 41, 8, 12, 93, 74, 76, 59, 68, 57, 88, 84, 44, 22, 27};
//        int[] array = {9, 5, 3};
//        int[] array = {};

        int right = array.length - 1;
        mergeSort(array, 0, right);

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    public static void mergeSort(int[] array, int left_idx, int right_idx) {
        if (left_idx < right_idx) {
            int middle = (left_idx + right_idx) / 2;
            mergeSort(array, left_idx, middle);
            mergeSort(array, middle + 1, array.length - 1);

            merge(array, left_idx, middle, right_idx);
        }
    }

    private static void merge(int[] array, int left_idx, int middle, int right_idx) {
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];

        for (int j = 0; j < left.length; j++) {
            left[j] = array[j];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = array[middle + j];
        }

        int i = 0;
        int l_idx = 0;
        int r_idx = 0;

        while (l_idx < left.length && r_idx < right.length) {
            if (left[l_idx] <= right[r_idx]) {
                array[i] = left[l_idx];
                ++l_idx;
            } else {
                array[i] = right[r_idx];
                ++r_idx;
            }
            i++;
        }

        while (l_idx < left.length && i < array.length) {
            array[i] = left[l_idx];
            ++i;
            ++l_idx;
        }

        while (r_idx < right.length && i < array.length) {
            array[i] = right[r_idx];
            ++i;
            ++r_idx;
        }

    }
}
