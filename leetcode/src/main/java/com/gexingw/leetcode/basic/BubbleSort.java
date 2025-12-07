package com.gexingw.leetcode.basic;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};

        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    public static int[] bubbleSort(int[] unSort) {
        for (int i = 0; i < unSort.length; i++) {
            System.out.println(String.format("第%d轮", i));
            for (int j = 0; j < unSort.length - 1 - i; j++) {
                if (unSort[j] > unSort[j + 1]) {
                    int temp = unSort[j];
                    unSort[j] = unSort[j + 1];
                    unSort[j + 1] = temp;
                }

                System.out.println(Arrays.toString(unSort));
            }


        }

        return unSort;
    }

}
