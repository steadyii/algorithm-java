package com.steady.leetcode.d1_array;

/**
 * 给定升序不重复数组,使用二分查找target,返回下标
 */
public class BinarySearch {
    /**
     * 左右闭合写法,主要掌握
     */
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        //左右闭合,最后 left可能 = right
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    /**
     * 左闭右开写法,加深对边界的认识
     */
    
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        //在处理边界上的主要区别
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }
}
