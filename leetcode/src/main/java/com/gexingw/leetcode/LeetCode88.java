package com.gexingw.leetcode;

import java.util.Arrays;

/**
 * @author GeXingW
 */
public class LeetCode88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < m || j < n) {
            if (i == m) {
                nums[k++] = nums2[j++];
                continue;
            }

            if (j == n) {
                nums[k++] = nums2[i++];
                continue;
            }

            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        for (int l = 0; l <= nums.length - 1; l++) {
            nums1[l] = nums[l];
        }
    }

}
