package org.example.week18;

import org.example.week13.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode114 {
    public void flatten(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        dfs(root, queue);

        if(queue.size() > 0){
            root = queue.poll();
            while(!queue.isEmpty()){
                TreeNode next = queue.poll();
                root.right = next;
                root = next;
            }
        }
    }

    private void dfs(TreeNode node, Queue<TreeNode> queue) {
        if(node != null){
            queue.add(node);
        }else{
            return;
        }
        if(node.left != null){
            dfs(node.left, queue);
            node.left = null;
        }
        if(node.right != null){
            dfs(node.right, queue);
            node.right = null;
        }
    }
}
