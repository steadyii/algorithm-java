package com.steady.leetcode.d1_array;

/**
 * 给定数n,返回n方的二维数组
 */
public class Matrix {
    //4 -> 3,3,3,3    1,1,1,1
    //3 -> 2,2,2,2    1
    public int[][] generateMatrix(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start) --> 对角线..
        int count = 1;  // 定义填充数字
        int i, j;
        
        while (loop++ < n / 2) {
            // 判断边界后，loop从1开始 ,共有loop/2次循环
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;     //先参与赋值,后自增
            }
            
            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            
            // 模拟下侧从右到左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            
            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        
        //循环结束,奇数 -> 只剩中间的没填了
        if (n % 2 == 1) {
            res[start][start] = count;
        }
        
        return res;
    }
}
