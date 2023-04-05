package com.steady.leetcode.d9_dp;

public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,40};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {     //j >= weight[i]
                    dp[i][j] = Math.max(
                            dp[i-1][j] ,
                            value[i] + dp[i-1][j-weight[i]]
                    );
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    
    //使用一维数组
    static class SingleBag{
        public static void main(String[] args) {
            int[] weight = {1, 3, 4};
            int[] value = {15, 20, 30};
            int bagWight = 4;
            testWeightBagProblem(weight, value, bagWight);
        }
    
        public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
            int wLen = weight.length;
            
            //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
            int[] dp = new int[bagWeight + 1];
            //遍历顺序：先遍历物品，再遍历背包容量
            for (int i = 0; i < wLen; i++){
                for (int j = bagWeight; j >= weight[i]; j--){
                    dp[j] = Math.max(
                            dp[j],
                            dp[j - weight[i]] + value[i]
                    );
                }
            }
            //打印dp数组
            for (int j = 0; j <= bagWeight; j++){
                System.out.print(dp[j] + " ");
            }
        }
    }
}