package com.gexingw.sort;

/**
 * @author GeXingW
 */
public class MergeSort2 {
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h) {
            return new int[]{nums[l]};
        }

        int mid = l + (h - l) / 2;
        //左有序数组
        int[] leftArr = mergeSort(nums, l, mid);
        //右有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h);
        //新有序数组
        int[] newNum = new int[leftArr.length + rightArr.length];

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length) {
            newNum[m++] = leftArr[i++];
        }

        while (j < rightArr.length) {
            newNum[m++] = rightArr[j++];
        }
        return newNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 10};
        int[] newNums = mergeSort(nums, 0, nums.length - 1);
        for (int x : newNums) {
            System.out.println(x);
        }
    }

}
