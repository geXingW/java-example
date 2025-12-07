package com.gexingw.leetcode.practice;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class Test {

    public static void main(String[] args) {
        int[] sort = {5, 1, 3, 2, 4, 6, 7, 3, 8, 10};

//        System.out.println(Arrays.toString(bubbleSort(sort)));
//        System.out.println(Arrays.toString(selectSort(sort)));
//        System.out.println(Arrays.toString(insertSort(sort)));
        System.out.println(Arrays.toString(quickSort(sort, 0, sort.length - 1)));

    }

    public static int[] quickSort(int[] nums, int low, int high) {

        if (low >= high) {
            return nums;
        }

        int left = low;
        int right = high;
        int pivot = nums[low];

        System.out.printf("pivot：%d,low：%d,high：%d%n", pivot, low, high);

        while (left < right) {
            while (left < right && pivot <= nums[right]) {
                right--;
            }

            while (left < right && pivot >= nums[left]) {
                left++;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }

        nums[low] = nums[left];
        nums[left] = pivot;

        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, high);

        return nums;
    }

//    public static int[] bubbleSort(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] < nums[j]) {
//                    int temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//
//        return nums;
//    }

//    public static int[] selectSort(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int minIndex = i;
//
//            for (int j = i; j < nums.length; j++) {
//                if(nums[minIndex] > nums[j]) {
//                    minIndex = j;
//                }
//            }
//
//            int temp = nums[i];
//            nums[i] = nums[minIndex];
//            nums[minIndex] = temp;
//        }
//
//        return nums;
//    }

//    public static int[] insertSort(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int temp = nums[i];
//
//            int j = i;
//            while (j > 0 && temp < nums[j - 1]) {
//                nums[j] = nums[j - 1];
//                j--;
//            }
//
//            if(j != i) {
//                nums[j] = temp;
//            }
//
//        }
//
//        return nums;
//    }

}
