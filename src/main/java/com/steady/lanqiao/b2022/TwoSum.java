package com.steady.lanqiao.b2022;

import java.util.Scanner;

/**
 * 数组中所有两个数乘积的和<br>
 * 结果使用long,暂时保存数据,不用每次都加一遍
 */
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    
        long sum = 0;
        long res = 0;
        int[] ints = new int[n];
    
        for (int i = 0; i < n; i++) {
            ints[i] = sc.nextInt();
            sum += ints[i];
        }
        for (int i = 0; i < n; i++) {
            res += ints[i] * (sum - ints[i]);
            sum -= ints[i];
        }
        System.out.println(res);
    }
}
