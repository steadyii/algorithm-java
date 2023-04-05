package com.steady.lanqiao.b2022;

import java.util.Scanner;

/**
 * 字符串中出现最多的
 */
public class C_coll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int[] arr = new int[26];
        for (char c : next.toCharArray()) {
            arr[c - 65]++;
        }
        int max = 0;
        for (int j : arr) {
            if (max < j)
                max = j;
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i])
                System.out.print((char) (i + 65));
        }
       
    }
}
