package com.gexingw.leetcode.basic;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] sort = {5, 1, 3, 2, 4, 6, 7, 3, 8, 10};

        System.out.println(Arrays.toString(insertSort(sort)));
//        insertSort(sort);
    }

    public static int[] insertSort(int[] unSort) {
        for (int i = 0; i < unSort.length; i++) {
            System.out.println(String.format("第%d趟", i));

            int temp = unSort[i];
            int j = i;
            while (j > 0 && temp < unSort[j - 1]) {
                unSort[j] = unSort[j - 1];
                j--;
            }

            if (j != i) {
//                unSort[i] = unSort[j];
                unSort[j] = temp;
            }

//
//            for (int j = i; j > 0; j--) {
//                if (unSort[j] < unSort[j - 1]) {
//                    int temp = unSort[j];
//                    unSort[j] = unSort[j - 1];
//                    unSort[j - 1] = temp;
//                }
//            }

            System.out.println(Arrays.toString(unSort));
        }

        return unSort;
    }

    //

}
