package com.steady.leetcode.d3_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c <br>
 * 使得a + b + c = 0 ？<br>
 * 请你找出所有满足条件且不重复的三元组,返回三元组
 */
public class SumOfThree {
    /**
     * 三指针法
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
    
            if (i > 0 && nums[i] == nums[i - 1]) {  //第二次循环时 去重a
                continue;
            }
    
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    while (right > left && nums[left] == nums[left + 1])
                        left++;
            
                    //继续向中间缩进
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
