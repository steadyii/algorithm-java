package com.steady.leetcode.d7_back;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。<br>
 *
 * 返回 s 所有可能的分割方案。<br>
 * 输入:"aab"<br>
 * 输出:<br>
 * [<br>
 *   ["aa","b"], --> 一个链表中,存好几个回文串<br>
 *   ["a","a","b"]<br>
 * ]
 */
public class CutPalindrome {
    List<List<String>> lists = new ArrayList<>();
    Deque<String> deque = new LinkedList<>();
    
    public List<List<String>> partition(String s) {
        backTracking(s, 0);
        return lists;
    }
    
    private void backTracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            //如果是回文子串，则记录
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                //可以直接往结果集中添加
                deque.addLast(str);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backTracking(s, i + 1);
            deque.removeLast();
        }
    }
    //判断是否是回文串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
