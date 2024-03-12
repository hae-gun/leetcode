package org.example.week15;

import org.example.week13.TreeNode;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {

        if(root == null) return false;

        return checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode leftParent, TreeNode rightParent) {

        if(leftParent == null && rightParent == null) return true;
        if(leftParent == null || rightParent == null) return false;
        if(leftParent.val != rightParent.val) return false;

        return checkSymmetric(leftParent.left, rightParent.right) &&
                checkSymmetric(leftParent.right, rightParent.left);
    }
}
