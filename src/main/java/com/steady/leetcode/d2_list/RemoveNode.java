package com.steady.leetcode.d2_list;

/**
 * 移除链表中的元素<br>
 * 删除链表中等于给定值 val 的所有节点<br>
 * 返回头结点
 */
public class RemoveNode {
    /**
     * 添加虚节点方式<br>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);//头结点的前一个,指向头结点,不变
        
        ListNode pre = dummy;  //pre用来操作
        ListNode cur = head;
        while (cur != null) {        //开始从头遍历,pre紧跟cur
            if (cur.val == val) {
                pre.next = cur.next;      //删除
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
    
    /**
     * 不添加虚拟节点方式<br>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeElements1(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    
    
    
    
    /**
     * 不添加虚拟节点and pre Node方式<br>
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public ListNode removeElements2(ListNode head, int val) {
        //遍历,排除前部分的 = val节点
        while(head!=null && head.val==val){
            head = head.next;
        }
        //head == null ,跳过while直接返回了
        
        ListNode curr = head;     //保留head节点,使用辅助指针curr进行操作
        while(curr!=null){
            while(curr.next!=null && curr.next.val == val){ //null退出 / val 跳过
                curr.next = curr.next.next;
            }
            //正常情况下,继续往下走
            curr = curr.next;
        }
        return head;
    }
}
