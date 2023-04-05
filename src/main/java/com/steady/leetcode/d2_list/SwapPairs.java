package com.steady.leetcode.d2_list;

/**
 * 交换链表相邻的节点
 */
public class SwapPairs {
    /**
     * 头插法
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        
        dumyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        
        ListNode cur = dumyhead;
        
        ListNode temp; // 临时节点，保存两个节点后面的节点
        
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            
            //交换
            cur.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            
            cur = firstnode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }
    
    /**
     * 递归
     */
    public ListNode swapPairs1(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null)
            return head;
        
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs1(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;
        
        return next;
    }
    
    
    
}
