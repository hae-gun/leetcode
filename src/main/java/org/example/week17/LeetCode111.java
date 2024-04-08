package org.example.week17;

import org.example.week13.TreeNode;

public class LeetCode111 {
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        dfs(root, 1);
        return min;
    }
    void dfs(TreeNode root, int dept){
        if(root.right == null && root.left == null){
            min = Math.min(dept, min);
        }
        if(root.right != null) dfs(root.right, dept+1);
        if(root.left != null) dfs(root.left, dept+1);
    }
}
