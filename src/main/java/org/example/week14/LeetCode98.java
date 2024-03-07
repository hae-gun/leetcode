package org.example.week14;

import org.example.week13.TreeNode;

public class LeetCode98 {
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        if(root.val <= min || root.val >= max) {
            return false;
        }

        return checkBST(root.left, min, root.val) &&
                checkBST(root.right, root.val, max);
    }
}
