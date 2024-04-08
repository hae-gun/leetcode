package org.example.week2;

import java.util.ArrayList;
import java.util.List;

public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){this.val = val;}
    public ListNode(int val, ListNode next){this.val = val; this.next = next;}

    @Override
    public String toString() {
        List<Integer> result = new ArrayList<>();
        result.add(this.val);
        ListNode cur = this;
        while(cur.next != null){
            cur = cur.next;
            result.add(cur.val);
        }
        return result.toString();
    }
}
