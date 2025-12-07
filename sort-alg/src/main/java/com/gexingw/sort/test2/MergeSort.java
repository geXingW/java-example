package com.gexingw.sort.test2;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] unSort = {3, 1, 6, 5, 1, 4, 2, 0};

        System.out.println(Arrays.toString(mergeSort(0, unSort.length - 1, unSort)));

    }

    public static int[] mergeSort(int low, int high, int[] unSort) {
        System.out.println("low:" + low + ", high:" + high + ", UnSort:" + Arrays.toString(unSort));

        if (low == high) {
            return new int[]{unSort[low]};
        }

        int middle = (high + low) / 2;
        int[] left = mergeSort(low, middle, unSort);
        int[] right = mergeSort(middle + 1, high, unSort);

        int[] sorted = new int[left.length + right.length];

        int leftIdx = 0, rightIdx = 0, sortedIdx = 0;
        while (leftIdx < left.length && rightIdx < right.length) {
            sorted[sortedIdx++] = left[leftIdx] < right[rightIdx] ? left[leftIdx++] : right[rightIdx++];
        }

        while (leftIdx < left.length) {
            sorted[sortedIdx++] = left[leftIdx++];
        }

        while (rightIdx < right.length) {
            sorted[sortedIdx++] = right[rightIdx++];
        }

        return sorted;
    }

}
