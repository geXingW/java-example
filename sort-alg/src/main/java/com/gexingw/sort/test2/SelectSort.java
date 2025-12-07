package com.gexingw.sort.test2;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] unSort = {3, 1, 6, 5, 4, 2};
        System.out.println(Arrays.toString(selectSort(unSort)));
    }

    public static int[] selectSort(int[] unSort) {

        for(int i = 0; i < unSort.length; i++) {

            int minIdx = i;
            for(int j = i; j < unSort.length; j ++) {
                if(unSort[minIdx] > unSort[j]) {
                    minIdx = j;
                }
            }

            if(minIdx != i) {
                int temp = unSort[minIdx];
                unSort[minIdx] = unSort[i];
                unSort[i] = temp;
            }
        }

        return unSort;
    }


}
