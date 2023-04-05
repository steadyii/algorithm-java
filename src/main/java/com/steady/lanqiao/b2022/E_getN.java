package com.steady.lanqiao.b2022;

import java.util.Scanner;

/**
 * 求末尾有k个0的阶乘阶数
 */
public class E_getN {
    public static void main(String[] args)  {
        Scanner sc=new Scanner(System.in);
        long k=sc.nextLong();
        for (long i = k*4/5*5; i<=k*5; i+=5) {
            long cnt=0, n=i;
            while(n>0){
                n/=5;
                cnt+=n;
            }
            if(cnt>=k){
                if(cnt==k)System.out.println(i);
                else System.out.println(-1);
                return;
            }
        }
    }
}
