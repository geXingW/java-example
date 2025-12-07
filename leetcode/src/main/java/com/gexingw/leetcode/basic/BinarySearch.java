package com.gexingw.leetcode.basic;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] nums1 = {5, 1, 3, 2, 4, 6, 7, 3, 8, 10};
//        Arrays.sort(nums1);
//        System.out.println(Arrays.toString(nums1));

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 6;

        System.out.println(binarySearch(nums, target));

        new Thread(() -> {

        });

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };


    }

    public static int binarySearch(int[] nums, int target) {
//        int middle = nums.length / 2;
//        if (nums[middle] == target) {
//            return middle;
//        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            System.out.printf("left:%d,right:%d,middle:%d%n", left, right, middle);
            if (nums[middle] == target) {
                return middle;
            }

            if (target < nums[middle]) {
                right = middle - 1;
                continue;
            }

            left = middle + 1;
        }

        return -1;
    }

}
