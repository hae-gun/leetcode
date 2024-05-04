package org.example.week22;

import org.example.week2.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return null;

        Map<ListNode, Integer> nodes = new HashMap<>();
        int idx = 0;
        while(!nodes.containsKey(head)){
            nodes.put(head, idx++);
            head = head.next;
            if(head == null) break;
        }
        List<ListNode> sortedList = nodes.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .toList();
        if(head == null) return null;

        return head;
    }
}
