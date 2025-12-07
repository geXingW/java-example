package com.gexingw.sort.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author GeXingW
 */
public class BinarySearch {

    public static void main(String[] args) {
        new HashMap<>().put("a", "a");

        new ConcurrentHashMap<>().get("a");
        new ConcurrentHashMap<>().put("a", "b");

        ArrayList<Object> objects = new ArrayList<>(5);
//        int[] arr = {3, 1, 6, 5, 1, 4, 2, 0};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        System.out.println(binarySearch(0, arr.length - 1, arr, 11));

    }

    public static int binarySearch(int low, int high, int[] arr, int target) {
        System.out.printf("low:%d，high:%d%n", low, high);
        int middle = (low + high) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (arr[low] == target) {
            return low;
        }


        if (arr[high] == target) {
            return high;
        }


        if(low == high) {
            return -1;
        }

        if (arr[middle] < target) {
            return binarySearch(middle + 1, high, arr, target);
        }

        return binarySearch(low, middle - 1, arr, target);
    }


}
