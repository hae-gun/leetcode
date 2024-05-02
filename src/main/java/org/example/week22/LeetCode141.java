package org.example.week22;

import org.example.week2.ListNode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeetCode141 {
    public boolean hasCycle(ListNode head) {

        if(head == null) return false;
        if(head.next == null) return false;

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
        if(head == null) return false;
        int pos = nodes.get(head);

        return head == sortedList.get(pos);
    }
}
