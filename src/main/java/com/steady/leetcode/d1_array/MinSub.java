package com.steady.leetcode.d1_array;

/**
 * 给定一个数组和target,求最小连续数组,和 >= target
 */
public class MinSub {
    
    /**
     * 暴力解法,两层for O(n^2),已经超时
     */
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        
        int sum; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= s) {       //子序列和超过了s，更新 result长度
                    subLength = j - i + 1;     //当前子序列的长度
                    result = Math.min(result, subLength);
                    break;
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
    
    
    /**
     * 滑动窗口<br>
     * 使用快慢指针...
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1); //比较,取最小个数
                sum -= nums[left++];     //慢指针右移
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
