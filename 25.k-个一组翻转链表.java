/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 0) return head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end != null) {
                end = end.next;
            } else {
                return head;
            }
        }
        ListNode pre = head, cur = head.next, next;
        while (cur != null && cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(end, k);
        return pre;

    }
}
// @lc code=end

