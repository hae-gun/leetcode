package org.example.week16;

import org.example.week13.TreeNode;

public class LeetCode99 {
    private TreeNode first;
    private TreeNode second;
    private TreeNode pre;

    public void recoverTree(TreeNode root) {
        if (root == null) { // 현재 node가 null이면 아무 것도 하지 않습니다.
            return;
        }
        inorder(root); // 현재 노드를 inorder traversal로 탐색하며 검사합니다.
        if (second != null && first != null) { // swap 해야 할 두 노드를 발견했다면 swap해 줍니다.
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) { // 현재 노드가 null이면 아무 것도 하지 않습니다.
            return;
        }
        inorder(root.left); // 왼쪽 노드를 먼저 검사합니다.
        if (pre != null) { // 이전 노드가 존재하고
            if (root.val < pre.val) { // 현재 노드가 이전 노드보다 작고
                if (first == null) { // 첫 번째 노드를 아직 발견하지 못했다면
                    first = pre; // 이전 노드가 swap 해야 할 첫 번째 노드가 됩니다.
                }
                second = root; // 현재 노드를 swap 해야 할 두 번째 노드로 대체합니다.
            }
        }
        pre = root; // 이전 노드를 현재 노드로 대체합니다.
        inorder(root.right); // 오른쪽 노드를 나중에 검사합니다.
    }

}
