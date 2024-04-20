package org.example.week20;

import org.example.week13.TreeNode;

public class LeetCode129 {
    public int sumNumbers(TreeNode root) {
        return depthFirstSearch(root, 0);
    }

    private int depthFirstSearch(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return depthFirstSearch(node.left, sum) + depthFirstSearch(node.right, sum);
    }
}
