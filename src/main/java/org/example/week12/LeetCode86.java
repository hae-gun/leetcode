package org.example.week12;

import org.example.week2.ListNode;

public class LeetCode86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }

        ListNode tempHead = new ListNode(-1);
        ListNode smaller = tempHead;
        ListNode tempHead2 = new ListNode(-1);
        ListNode  bigger = tempHead2;

        while(head!=null){
            if(head.val < x){
                smaller.next = head;
                smaller = smaller.next;
            }else{
                bigger.next = head;
                bigger = bigger.next;
            }
            head = head.next;
        }

        bigger.next = null;
        smaller.next = tempHead2.next;
        return tempHead.next;
    }
}
