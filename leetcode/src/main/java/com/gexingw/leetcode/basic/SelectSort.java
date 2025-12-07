package com.gexingw.leetcode.basic;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] sort = {5, 1, 3, 2, 4, 6, 7, 3, 8, 10};

        System.out.println(Arrays.toString(selectSort(sort)));
    }

    public static int[] selectSort(int[] unSort) {
        for (int i = 0; i < unSort.length; i++) {
            System.out.println(String.format("第%d趟", i));
            int min = i;

            for (int j = i; j < unSort.length; j++) {
                if (unSort[min] > unSort[j]) {
                    min = j;
                }
            }

            System.out.println(String.format("最小数%d", unSort[min]));

            int temp = unSort[i];
            unSort[i] = unSort[min];
            unSort[min] = temp;
            System.out.println(Arrays.toString(unSort));
        }

        return unSort;
    }

}
