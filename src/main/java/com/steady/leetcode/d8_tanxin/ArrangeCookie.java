package com.steady.leetcode.d8_tanxin;

import java.util.Arrays;

/**
 * 分发饼干
 * g = [1,2,3], s = [1,1]<br>
 * 输出: 1
 */
public class ArrangeCookie {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        
        for (int i = s.length - 1,leave = g.length - 1; i >= 0 && leave >= 0;leave--) {
            if (s[i] >= g[leave]){
                res++;
                i--;
            }
        }
        return res;
    }
    
}