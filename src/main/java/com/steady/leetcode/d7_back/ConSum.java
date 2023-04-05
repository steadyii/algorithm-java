package com.steady.leetcode.d7_back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。<br>
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。<br>
 * 输入: k = 3, n = 9<br>
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class ConSum {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        build(k, n, 1, 0);
        return ans;
    }
    
    private void build(int k, int n, int startIndex, int sum) {
        
        if (sum > n) return;
        
        if (path.size() > k) return;
        
        if (sum == n && path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = startIndex; i <= 9; i++) {
            path.add(i);
            sum += i;
            build(k, n, i + 1, sum);
            sum -= i;
            path.removeLast();
        }
    }
}
