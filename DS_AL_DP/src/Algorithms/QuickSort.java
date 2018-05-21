package Algorithms;

/**
 * Recursive implementation of Quick Sort
 */

public class QuickSort {
    public static void main(String[] args) {
//        int[] array = {6, 9, 2, 8, 0};
        int[] array = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50};

        int left_idx = 0;
        int right_idx = array.length - 1;

        quickSort(array, left_idx, right_idx);

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }

    private static void quickSort(int[] array, int left_idx, int right_idx) {
        if (left_idx >= right_idx){
            return;
        }

        int pivot = partition(array, left_idx, right_idx);
        quickSort(array, left_idx, pivot);
        quickSort(array, pivot+1 , array.length-1);
    }

    private static int partition(int[] array, int left_idx, int right_idx) {
        int pivot_index = left_idx;
        int pivot = array[pivot_index]; //first elem index
        int swap_index = pivot_index + 1;

        for (int i = pivot_index + 1; i <= right_idx; i++) {
            if(array[i] < pivot){
                int temp = array[swap_index];
                array[swap_index] = array[i];
                array[i] = temp;
                swap_index += 1;
            }
        }
        int temp = array[swap_index-1];
        array[swap_index-1] = pivot;
        array[pivot_index] = temp;

        return swap_index-1;
    }
}
