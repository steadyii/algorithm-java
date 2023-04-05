package com.steady.leetcode.d9_dp;

/**
 * 给定一个只包含正整数的非空数组。<br>
 * 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 */
public class CanPartition {
    
    //使用一维数组的动态规划
    public boolean canPartition2(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        
        int[] dp = new int[target + 1];
    
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(      //不会超过dp的下标
                        dp[j],   //上一次的值
                        dp[j - num] + num //使用上一次的数据，加上当前的值
                );
            }
        }
        return dp[target] == target;
    }
    
    //使用二维数组的动态规划
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;
        
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
    
    
    
    
    //回溯,已经超时
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        return backtracking(nums, 0, target);
    }
    
    public boolean backtracking(int[] arr, int start, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        
        for (int i = start; i < arr.length; i++) {
            if (backtracking(arr, i + 1, target - arr[i])) {
                return true;
            }
        }
        return false;
    }
}
