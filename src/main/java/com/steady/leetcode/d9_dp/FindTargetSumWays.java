package com.steady.leetcode.d9_dp;

/**
 * 输入：nums = [1,1,1,1,1], target = 3<br>
 * 输出：5
 */
public class FindTargetSumWays {
    
    //回溯暴力搜索
    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        back(nums,0,0,target);
        return res;
    }
    private void back(int[] nums, int sum, int index,int target){
        // 必须整个数组元素都用上
        if(index == nums.length){
            if(sum == target){
                res++;
            }
            return;
        }
        back(nums,sum + nums[index],index + 1,target);
        back(nums,sum - nums[index],index + 1,target);
    }
    
    
    //动态规划,二维数组,dp[i][j]表示前i个元素和为j的方案数
    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < target || (sum + target) % 2 == 1){
            return 0;
        }
        int w = (sum + target) / 2;
        
        int[][] dp = new int[nums.length + 1][w + 1];
        
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++){
            int num = nums[i - 1];
            for(int j = 0; j <= w; j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= num){
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        return dp[nums.length][w];
    }
    
    //动态规划,一维数组
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < target || (sum + target) % 2 == 1){
            return 0;
        }
        //背包容量
        int w = (sum + target) / 2;   // w = (sum - target) / 2 + target = (sum + target) / 2
        
        int[] dp = new int[w + 1];
        
        dp[0] = 1;
        for(int num : nums){
            for(int j = w; j >= num; j--){
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }
}
