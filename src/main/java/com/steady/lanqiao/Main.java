package com.steady.lanqiao;
//计算51的阶乘
public class Main {
    public static void main(String[] args) {
        int[] a = new int[1000];
        a[0] = 1;
        int len = 1;
        for (int i = 1; i <= 51; i++) {
            len = multiply(a, len, i);
        }
        for (int i = len - 1; i >= 0; i--) {
            System.out.print(a[i]);
        }
    }
    private static int multiply(int[] a, int len, int i) {
        int carry = 0;
        for (int j = 0; j < len; j++) {
            int temp = a[j] * i + carry;
            a[j] = temp % 10;
            carry = temp / 10;
        }
        while (carry != 0) {
            a[len] = carry % 10;
            carry /= 10;
            len++;
        }
        return len;
    }
}

