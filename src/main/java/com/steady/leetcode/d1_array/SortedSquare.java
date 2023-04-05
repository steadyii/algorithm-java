package com.steady.leetcode.d1_array;

import java.util.Arrays;

/**
 * 给定升序数组nums[],返回每个数的平方组成的新数组,要求也按升序排<br>
 * 输入：nums = [-4,-1,0,3,10]<br>
 * 输出：[0,1,9,16,100]
 */
public class SortedSquare {
    /**
     * 暴力 O(n + nlogn)
     */
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);  //快速排序
        return nums;
    }
    /**
     * 双指针法<br>
     * 数组的最大数在两端,使用相向双指针,比较后插入新的数组
     */
    public int[] sortedSquares1(int[] nums) {
        int[] ints = new int[nums.length];
        int index = nums.length - 1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end){
            int s = nums[start] * nums[start];
            int e = nums[end] * nums[end];
            if (s < e){
                ints[index--] = e;
                end--;
            }else {
                ints[index--] = s;
                start++;
            }
        }
        return ints;
    }
    
}
