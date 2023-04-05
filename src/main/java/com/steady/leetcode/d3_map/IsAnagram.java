package com.steady.leetcode.d3_map;

/**
 * 判断b单词是否是a的字母异位词 -> 字母个数种类相同,但是出现的位置不同
 */
public class IsAnagram {
    /**
     * 只使用数组->简单的map<br>
     * 有统计&小写字母
     */
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count: record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

}
