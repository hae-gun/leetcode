package org.example.week8;

import org.example.week2.ListNode;

public class LeetCode61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dHead = new ListNode(0);
        dHead.next = head;
        ListNode fast = dHead, slow = dHead;

        int len = 0;
        while (fast.next != null) {
            fast = fast.next; //Get the total length
            len++;
        }

        k = k % len;
        int i = len-k;
        while(i > 0){ //Get the len-k th node
            slow = slow.next;
            i--;
        }

        fast.next = dHead.next; //Do the rotation
        dHead.next = slow.next;
        slow.next = null;

        return dHead.next;

    }
}
