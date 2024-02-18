package org.example.week11;

import org.example.week2.ListNode;

public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dHead = new ListNode(-1);
        dHead.next = head;
        ListNode prev = dHead;
        ListNode cur = head;
        while(cur != null){

            while(cur.next!=null && cur.val==cur.next.val){
                cur=cur.next;
            }
            if(prev.next == cur){
                prev=prev.next;
            } else{
                prev.next=cur.next;
            }
            cur = cur.next;
        }
        return dHead.next;
    }
}
