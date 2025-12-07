package com.gexingw.sort.test2;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] unSort = {3, 1, 6, 5, 4, 2, 0};
        System.out.println(Arrays.toString(insertSort(unSort)));

    }

    public static int[] insertSort(int[] unSort) {
        for (int i = 0; i < unSort.length; i++) {

            for (int j = i; j > 0; j--) {
                if (unSort[j] >= unSort[j - 1]) {
                    continue;
                }

                int temp = unSort[j];
                unSort[j] = unSort[j - 1];
                unSort[j - 1] = temp;
            }
            System.out.println(String.format("第%d次排序：", i) + Arrays.toString(unSort));
        }

        return unSort;

    }
}
