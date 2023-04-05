package com.steady.leetcode.d4_string;

/**
 * 每隔2k个字符,翻转前k个<br>
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 */
public class ReverseK {
    public String reverseStr(String s, int k) {
        StringBuilder res = new StringBuilder();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuilder temp = new StringBuilder();
            // 与length进行判断，如果大于length了，那就将其置为length
            //可能是最后一组
            int firstK = Math.min(start + k, length);
            
            int secondK = Math.min(start + (2 * k), length);
            
            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());
            
            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();
    }
}
