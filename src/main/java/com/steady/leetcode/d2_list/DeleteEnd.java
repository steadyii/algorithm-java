package com.steady.leetcode.d2_list;

/**
 * 删除倒数第n个节点,并返回头结点<br>
 * n不超过链表长度
 */
public class DeleteEnd {
    /**
     * 快慢指针
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        
        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;
        
        //只要快慢指针相差 n 个结点即可
        for (int i = 0; i < n ; i++){
            fastIndex = fastIndex.next;
        }
        
        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }
        
        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }
}
