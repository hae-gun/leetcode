package org.example.week17;

import org.example.week13.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode112 {
    Set<Integer> set = new HashSet<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = false;
        if(root == null) return result;

        dfs(root, 0, targetSum);

        return set.contains(targetSum);
    }

    private void dfs(TreeNode node, int prevSum, int targetSum) {
        prevSum += node.val;
        if(isLeaf(node)){
            if(targetSum == prevSum){
                set.add(prevSum);
            }
        }

        if(node.left != null){
            dfs(node.left, prevSum, targetSum);
        }
        if(node.right != null){
            dfs(node.right, prevSum, targetSum);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
