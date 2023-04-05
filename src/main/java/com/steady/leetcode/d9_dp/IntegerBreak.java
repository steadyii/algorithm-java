package com.steady.leetcode.d9_dp;

/**
 * 给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化<br>
 * 返回你可以获得的最大乘积。
 */
public class IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
