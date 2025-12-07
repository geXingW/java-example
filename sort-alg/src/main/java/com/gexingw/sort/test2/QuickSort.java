package com.gexingw.sort.test2;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[] unSort = {3, 1, 6, 5, 1, 4, 2, 0};

        System.out.println(Arrays.toString(quickSort(0, unSort.length - 1, unSort)));
    }


    public static int[] quickSort(int low, int high, int[] unSort) {
        if (low >= high) {
            return unSort;
        }

        int left = low, right = high;
        int pivot = unSort[low];

        while(left < right) {
            while (left < right && unSort[right] >= pivot) {
                right--;
            }

            while(left < right && unSort[left] <= pivot) {
                left++;
            }

            if(right > left) {
                int temp = unSort[left];
                unSort[left] = unSort[right];
                unSort[right] = temp;
            }

        }

        unSort[low] = unSort[left];
        unSort[left] = pivot;

        quickSort(low, left - 1, unSort);
        quickSort(left + 1, high, unSort);

        return unSort;
    }

}
