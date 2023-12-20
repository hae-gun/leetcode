package org.example.day2;

import java.util.ArrayList;
import java.util.List;

public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dHead = new ListNode(0);
        dHead.next = head;
        ListNode cur = dHead;
        while(cur.next != null && cur.next.next != null){
            //swap
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = cur.next.next;
        }
        return dHead.next;
    }

}
