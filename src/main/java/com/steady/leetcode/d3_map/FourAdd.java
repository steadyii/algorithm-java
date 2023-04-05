package com.steady.leetcode.d3_map;

import java.util.HashMap;
import java.util.Map;

/**
 * 在四个长度为n的数组中,各找一个数,使其相加 = 0<br>
 * 只返回组数
 */
public class FourAdd {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        //分为 2,2 两组,分别放和判断
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        int res = 0;
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                temp = i + j;
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);//map的put,如果key存在，会覆盖value
                } else {
                    map.put(temp, 1);
                }
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                temp = i + j;
                if (map.containsKey(-temp)) {
                    res += map.get(-temp);
                }
            }
        }
        return res;
    }
}
