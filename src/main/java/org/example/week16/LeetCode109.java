package org.example.week16;

import org.example.week13.TreeNode;
import org.example.week2.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> numbers = new ArrayList<>();
        while(head != null){
            numbers.add(head.val);
            head = head.next;
        }
        return buildBST(numbers, 0, numbers.size() - 1);
    }

    private TreeNode buildBST(List<Integer> numbers, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(numbers.get(mid));
        root.left = buildBST(numbers, start, mid - 1);
        root.right = buildBST(numbers, mid + 1, end);
        return root;
    }

    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null)
            return null;
        TreeNode root = new TreeNode();
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        root.val = slow.val;
        if(slow == head)
            return root;
        prev.next = null;
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;

    }


}
