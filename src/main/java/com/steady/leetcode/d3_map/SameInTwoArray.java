package com.steady.leetcode.d3_map;

import java.util.HashSet;
import java.util.Set;

/**
 * 找到两个数组中相同元素,去重后返回<br>
 * 直接一个一个的去找时间复杂度太高了<br>
 * 使用hashset去找会好很多
 */
public class SameInTwoArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
    
        return resSet.stream().mapToInt(x -> x).toArray();
    }
}
