package com.steady.lanqiao;

import java.util.Scanner;

public class YngHui {
    static long[] a = new long[100050];
    static long n, sum, line; // sum等于1~line行的数字个数
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextLong();
        sum = a[0] = 1;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        for (line = 1; line < 50000; line++) { // line：杨辉三角的第line行
            for (int i = (int) line; i >= 1; i--) { // 倒过来循环，和DP的自我滚动数组的原理一样
                a[i] = a[i - 1] + a[i]; // 上一行的2个数相加得下一行的一个数
                if (a[i] == n) {
                    System.out.println(sum + line - i + 1);
                    return;
                }
            }
            sum += (line + 1); // 1~line行的数字个数。每行比上一行多一个，累加
        }
    }
}