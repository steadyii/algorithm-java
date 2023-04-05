package com.steady.leetcode.d7_back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组nums，返回该数组所有可能的子集（幂集）。
 *<br>
 * 说明：解集不能包含重复的子集。
 */
public class SubArrays {
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }
    
    private void subsetsHelper(int[] nums, int startIndex){
        //遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
