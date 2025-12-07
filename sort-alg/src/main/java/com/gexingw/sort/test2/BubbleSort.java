package com.gexingw.sort.test2;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] unSort = {5, 3, 2, 1, 4};

        System.out.println(Arrays.toString(bubbleSort(unSort)));
    }

    public static int[] bubbleSort(int[] unSort) {
        for (int i = 0; i < unSort.length; i++) {
            for (int j = 0; j < unSort.length - i - 1; j++) {
                if (unSort[j] > unSort[j + 1]) {
                    int temp = unSort[j];
                    unSort[j] = unSort[j + 1];
                    unSort[j + 1] = temp;
                }
                System.out.println(String.format("第%d次排序：", j) + Arrays.toString(unSort));

            }
            System.out.println();
//            System.out.println(String.format("第%d次排序：", i) + Arrays.toString(unSort));
        }

        return unSort;
    }

}
