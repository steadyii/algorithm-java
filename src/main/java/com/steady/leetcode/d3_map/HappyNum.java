package com.steady.leetcode.d3_map;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个数是不是快乐数<hr>
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1<br>
 * 也可能是 无限 循环 但始终变不到 1<br>
 * 如果 可以变为  1，那么这个数就是快乐数。
 */
public class HappyNum {
    //题目中说了会 无限循环，那么也就是说求和的过程中，sum会重复出现
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
