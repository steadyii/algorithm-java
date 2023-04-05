package com.steady.leetcode.d5_stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * 删除相邻的相同字符
 */
public class DeleteDup {

    public String removeDuplicates(String S) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外 会快一点
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < S.length(); i++) {
            ch = S.charAt(i);
            if (deque.isEmpty() || deque.peek() != ch) {
                deque.push(ch);
            } else {
                deque.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str.insert(0, deque.pop());
        }
        return str.toString();
    }
    public String removeDuplicatess(String S) {
        //ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        Stack<Character> stack = new Stack<>();
        
        for (char c : S.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        //剩余的元素即为不重复的元素
        while (!stack.isEmpty()) {
            str.insert(0, stack.pop());
        }
        return str.toString();
    }
    
    
    public String removeDuplicates1(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }
}
