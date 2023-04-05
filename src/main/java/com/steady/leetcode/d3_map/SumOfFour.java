package com.steady.leetcode.d3_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d<br>
 * 使得a + b + c + d的值与target相等？<br>
 * 找出并返回所有满足条件且不重复的四元组
 */
public class SumOfFour {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
    
        for (int i = 0; i < nums.length; i++) {
        
            // nums[i] > target 直接返回, 剪枝操作
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
        
            if (i > 0 && nums[i - 1] == nums[i]) {    // 对nums[i]去重
                continue;
            }
        
            for (int j = i + 1; j < nums.length; j++) {
            
                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                    continue;
                }
            
                int left = j + 1;
                int right = nums.length - 1;
                while (right > left) {
                    // nums[k] + nums[i] + nums[left] + nums[right] > target int会溢出
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对nums[left]和nums[right]去重
                        while (right > left && nums[right] == nums[right - 1]) right--;
                        while (right > left && nums[left] == nums[left + 1]) left++;
                    
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
