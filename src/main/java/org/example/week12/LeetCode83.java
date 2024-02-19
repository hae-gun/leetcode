package org.example.week12;

import org.example.week2.ListNode;

public class LeetCode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = head;
        ListNode first = new ListNode(-1, prev);
        while(head.next != null){
            head = head.next;
            if(prev.val != head.val){
                prev.next = head;
                prev = prev.next;
            }else{
                prev.next = null;
            }
        }
        return first.next;
    }
}
