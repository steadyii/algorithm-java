package com.steady.leetcode.d3_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个字符串数组 words<br>
 * 请你找出所有在 words 的每个字符串中都出现的共用字符（包括重复字符）<br>
 * 并以数组形式返回。你可以按 任意顺序 返回答案。<br>
 * <hr>
 * 1 <= words.length <= 100<br>
 *  1 <= words[i].length <= 100
 */
public class FindConChar {
    /**
     * 仍然使用数组记录<br>
     */
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        
        //取第一个字符串拆成数组,然后和其他的每一个比较,每个字符数量取最小值
        int[] hash = new int[26];
        for (char c : A[0].toCharArray()) {
            hash[c - 'a']++;
        }
        
        for (String s : A) {
            int[] temp = new int[26];
            for (char c : s.toCharArray()) {
                temp[c - 'a']++;
            }
            // 更新hash，保证hash里统计26个字符在所有字符串里出现的最小次数
            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min(hash[k], temp[k]);
            }
        }
        // 将hash统计的字符次数，转成输出形式
        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) { // 注意这里是while，多个重复的字符
                char c= (char) (i+'a');
                result.add(String.valueOf(c));
                hash[i]--;
            }
        }
        return result;
    }
}











