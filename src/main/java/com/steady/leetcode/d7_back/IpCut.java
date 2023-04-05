package com.steady.leetcode.d7_back;

import java.util.ArrayList;
import java.util.List;

/**
 * 将给定的字符串转换为ip
 */
public class IpCut {
    List<String> result = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    
    public List<String> restoreIpAddresses(String s) {
        restoreIpAddressesHandler(s, 0, 0);
        return result;
    }
    
    // number表示stringbuilder中ip段的数量
    public void restoreIpAddressesHandler(String s, int start, int number) {
        // 如果start等于s的长度并且ip段的数量是4，则加入结果集，并返回
        if (start == s.length() && number == 4) {
            result.add(stringBuilder.toString());
            return;
        }
        // 如果start等于s的长度但是ip段的数量不为4，或者ip段的数量为4但是start小于s的长度，则直接返回
        if (start == s.length() || number == 4) {
            return;
        }
        
        // 剪枝：ip段的长度最大是3，并且ip段处于[0,255]
        for (int i = start;
                i < s.length() && i - start < 3
                && Integer.parseInt(s.substring(start, i + 1)) <= 255;
             i++) {
            // 如果ip段的长度大于1，并且第一位为0的话，continue,继续上一层的for
            if (i + 1 - start > 1 && s.charAt(start) - '0' == 0) {
                continue;
            }
            stringBuilder.append(s.substring(start, i + 1));
            // 当stringBuilder里的网段数量小于3时，才会加点；如果等于3，说明已经有3段了，最后一段不需要再加点
            if (number < 3) {
                stringBuilder.append(".");
            }
            number++;
            restoreIpAddressesHandler(s, i + 1, number);
            number--;
            // 删除当前stringBuilder最后一个网段，注意考虑点的数量的问题
            stringBuilder.delete(start + number, i + number + 2);
        }
    }
}
