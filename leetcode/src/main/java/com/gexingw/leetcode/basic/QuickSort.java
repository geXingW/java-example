package com.gexingw.leetcode.basic;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 2, 4, 6, 7, 3, 8, 10};

        System.out.println(Arrays.toString(quickSort(nums, 0, nums.length - 1)));
    }

    public static int[] quickSort(int[] nums, int low, int high) {
        System.out.println(Arrays.toString(nums));
        if (low >= high) {
            return nums;
        }

        int left = low, right = high;
        int pivot = nums[low];
        System.out.printf("pivot：%d,low：%d,high：%d%n", pivot, low, high);
        while (right > left) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }

            while (left < right && nums[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        System.out.println("排序后：" + Arrays.toString(nums));

        nums[low] = nums[left];
        nums[left] = pivot;

        quickSort(nums, low, left - 1);
        quickSort(nums, left + 1, high);

        return nums;
    }

}
