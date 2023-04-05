package com.steady.leetcode.d8_tanxin;

public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff;
        //上一个差值
        int preDiff = 0;
        
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff,或者重复的值
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
    
    public int wiggleMaxLengthDP(int[] nums) {
        // 0 i 作为波峰的最大长度
        // 1 i 作为波谷的最大长度
        int[][] dp = new int[nums.length][2];
        
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            //i 自己可以成为波峰或者波谷
            dp[i][0] = dp[i][1] = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    // i 是波谷
                    dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                }
                if (nums[j] < nums[i]) {
                    // i 是波峰
                    dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                }
            }
        }
        
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }
}
