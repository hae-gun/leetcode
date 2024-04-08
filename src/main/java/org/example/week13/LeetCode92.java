package org.example.week13;

import org.example.week2.ListNode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        if (left == right) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = new ListNode();
        prev.next = head;
        for (int i = 0; i < left - 1; i++) {
            prev = cur;
            cur = cur.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        if (left == 1) {
            return prev.next;
        } else {
            return head;
        }
    }
}
