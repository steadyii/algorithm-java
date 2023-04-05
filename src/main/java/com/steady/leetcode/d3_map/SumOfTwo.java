package com.steady.leetcode.d3_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和,数组中找两个数,使其和为target,并返回下标
 */
public class SumOfTwo {
    //需要记录元素,同时获得下标,使用map
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }
}
