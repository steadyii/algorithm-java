package com.steady.leetcode.d7_back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
   给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集<br>
 * 说明：解集不能包含重复的子集。
 */
public class SubArraysRepeat {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums ) {
        Arrays.sort( nums );
        subsetsWithDupHelper( nums, 0 );
        return res;
    }
    
    
    private void subsetsWithDupHelper( int[] nums, int start ) {
        res.add( new ArrayList<>( path ) );
        
        for ( int i = start; i < nums.length; i++ ) {
            // 跳过当前树层使用过的、相同的元素
            if ( i > start && nums[i - 1] == nums[i] ) {
                continue;
            }
            path.add( nums[i] );
            subsetsWithDupHelper( nums, i + 1 );
            path.removeLast();
        }
    }
}
