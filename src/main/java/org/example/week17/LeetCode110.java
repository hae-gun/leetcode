package org.example.week17;

import org.example.week13.TreeNode;

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        return check(root, 1) != -1;
    }

    public int check(TreeNode tree, int height) {
        if(tree == null) return height;

        int rightHeight = check(tree.right, 1);
        int leftHeight = check(tree.left, 1);

        if( Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        }

        return Math.max(check(tree.right, height+1), check(tree.left, height+1));
    }

}
