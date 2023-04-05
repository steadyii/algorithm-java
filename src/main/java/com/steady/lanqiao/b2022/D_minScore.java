package com.steady.lanqiao.b2022;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 小蓝老师教的编程课有 N 名学生，编号依次是 1 . . . N。第 i 号学生这学期刷题的数量是 Ai。
 *
 * 对于每一名学生，请你计算他至少还要再刷多少道题，才能使得全班刷题比他多的学生数不超过刷题比他少的学生数。
 */
public class D_minScore {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        
        int[] b = a.clone();
        Arrays.sort(b);
        
        int big_cnt = 0, sml_cnt = 0;
        
        for (int i = 0; i < n; i++)
            if (a[i] < b[n / 2])
                sml_cnt++;
            else if (a[i] > b[n / 2])
                big_cnt++;
            
        if (big_cnt < sml_cnt) {
            for (int i = 0; i < n; i++) {
                if (a[i] < b[n / 2])
                    System.out.print(b[n / 2] - a[i] + " ");
                else
                    System.out.print(0 + " ");
            }
        } else if (big_cnt > sml_cnt) {
            for (int i = 0; i < n; i++)
                if (a[i] <= b[n / 2])
                    System.out.print((b[n / 2] - a[i] + 1) + " ");
                else
                    System.out.print(0 + " ");
        } else {
            for (int i = 0; i < n; i++)
                if (a[i] < b[n / 2])
                    System.out.print((b[n / 2] - a[i] + 1) + " ");
                else
                    System.out.print(0 + " ");
        }
        scanner.close();
    }
}
