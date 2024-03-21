package org.example.week16;


import org.example.week13.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            while (!que.isEmpty()) {
                TreeNode node = que.poll();
                level.add(node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }

            ret.add(0, level);  // 순회를 bottom-up 으로 넣기 위해 항상 0번 인덱스에 리스트 삽입
        }
        return ret;
    }
    public void solution(){
        this.levelOrderBottom(new TreeNode(100));
    }

    public static void main(String[] args) {
        LeetCode107 sol = new LeetCode107();
        sol.levelOrderBottom(new TreeNode(10));
    }
}
