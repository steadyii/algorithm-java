package com.steady.leetcode.d4_string;

/**
 * 输入: s = "abcdefg", k = 2   <br>
 * 输出:"cdefgab"   <br>
 * 不能申请额外空间，只能在本串上操作
 */
public class ReverseLeft {
    
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, len - 1);
        return sb.reverse().toString();
    }
    
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
