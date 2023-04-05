package com.steady.leetcode.d8_tanxin;

/**
 * 返回数组最大子序和
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            count += num;
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0) {
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }
    
    public int maxSubArrayDP(int[] nums) {
        int ans;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        ans = dp[0];
        
        for (int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            ans = Math.max(dp[i], ans);
        }
        
        return ans;
    }
}
