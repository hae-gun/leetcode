package org.example.week4;

import org.example.week2.ListNode;

public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int num = 1;
        ListNode next = null;
        ListNode answer = null;
        ListNode prevReverseNode = null;
        while (cur != null) {
            if (num == k) {
                next = cur.next;
                cur.next = null;
                ListNode reverseNode = reverse(head);
                if (prevReverseNode != null) {
                    for (int i = 0; i < k - 1; i++) {
                        prevReverseNode = prevReverseNode.next;
                    }
                    prevReverseNode.next = reverseNode;
                } else {
                    answer = reverseNode;
                }
                prevReverseNode = reverseNode;
                num = 1;
                cur = next;
                head = cur;
            } else {
                num++;
                cur = cur.next;
            }
        }
        if (num <= k) {
            if (prevReverseNode != null) {
                for (int i = 0; i < k - 1; i++) {
                    prevReverseNode = prevReverseNode.next;
                }
                prevReverseNode.next = head;
            }
        }
        return answer;
    }

    public ListNode reverse(ListNode head) {
        int n = 0;
        ListNode cur = head;
        if (head == null) {
            return null;
        }
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        if (n == 1) {
            return head;
        }
        cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = null;
        return prev;
    }
}
