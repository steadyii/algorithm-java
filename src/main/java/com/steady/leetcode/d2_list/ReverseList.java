package com.steady.leetcode.d2_list;

import java.util.Stack;

/**
 * 翻转链表<br>
 * 返回翻转后的头结点
 */
public class ReverseList {
    /**
     * 双指针法,两个相邻指针,同时遍历,改变指向<br>
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp;
        
        while (cur != null) {
            temp = cur.next;        // 保存下一个节点,cur = temp;最后赋值给cur
            
            cur.next = prev;
            
            //覆盖地址
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    
    
    /**
     * 递归<br>
     * 思想与双指针相似
     */
    public ListNode reverseList1(ListNode head) {
        return reverse(null, head);
    }
    
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
    
    
    
    /**
     * 从后往前反向递归
     */
    ListNode reverseList2(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;
    
        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList2(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }
    
    
    
    /**
     * 头插法<br>
     * 使用虚拟头结点，通过头插法实现链表的翻转
     */
   
    public static ListNode reverseList3(ListNode head) {
        // 创建虚头结点
        ListNode dumpyHead = new ListNode(-1);
        dumpyHead.next = null;
        // 遍历所有节点
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            // 头插法
            cur.next = dumpyHead.next;
            dumpyHead.next = cur;
            cur = temp;
        }
        return dumpyHead.next;
    }
    
    
    
    /**
     *  使用栈解决反转链表的问题<br>
     *  首先将所有的结点入栈
     * 然后创建一个虚拟虚拟头结点，让cur指向虚拟头结点。<br>
     * 然后开始循环出栈，每出来一个元素，就把它加入到以虚拟头结点为头结点的链表当中，最后返回即可。
     */
    public ListNode reverseList4(ListNode head) {
        // 如果链表为空，则返回空
        if (head == null) return null;
        // 如果链表中只有只有一个元素，则直接返回
        if (head.next == null) return head;
        
        // 创建栈 每一个结点都入栈
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        //遍历完,cur == null
        ListNode pHead = new ListNode(0);     // 创建一个虚拟头结点
        cur = pHead;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        // 最后一个元素的next要赋值为空
        cur.next = null;
        return pHead.next;
    }
}
