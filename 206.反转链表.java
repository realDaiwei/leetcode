import java.util.List;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 循环
        // ListNode res = new ListNode();
        // ListNode cur;
        // while(head != null) {
        //     cur = head;
        //     head = head.next;
        //     cur.next = res.next;
        //     res.next = cur;
        //     cur = res.next;
        // }
        // return res.next;

        //递归
        if (head == null  || head.next == null) return head;
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
// @lc code=end

