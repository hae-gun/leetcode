package org.example.week15;

import org.example.week13.TreeNode;

import java.util.*;

public class LeetCode104 {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int maxDepth(TreeNode root) {
        int result = 0;

        if(root == null) return result;

        makeOrder(0, root);

        Set<Integer> integers = map.keySet();

        return integers.stream().reduce(Integer::max).get() +  1;
    }
    private void makeOrder(int level, TreeNode node){
        if(node != null){
            pushNode(level, node.val);
            if(node.left != null){
                makeOrder(level+1, node.left);
            }
            if(node.right != null){
                makeOrder(level+1, node.right);
            }
        }
    }

    private void pushNode(int level, int node){
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<Integer>());
        }
        map.get(level).add(node);
    }

}
