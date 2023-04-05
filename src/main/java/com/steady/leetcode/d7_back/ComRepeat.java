package com.steady.leetcode.d7_back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定不重复的目标数组,元素可以重复选取<br>
 * 结果不能重复
 */
public class ComRepeat {
    public static void main(String[] args) {
        System.out.println(
                new ComRepeat().combinationSum(new int[]{2, 3, 6, 7}, 7)
        );
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }
    
    public void backtracking(List<List<Integer>> res,
                             List<Integer> path,
                             int[] candidates,
                             int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}
