package org.example.week15;

import org.example.week13.TreeNode;

import java.util.*;

public class LeetCode103 {
    private Map<Integer, List<Integer> > map = new HashMap<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        makeOrder(0, root);
        for(int key : map.keySet()){
            if(key % 2 == 1){
                List<Integer> integers = map.get(key);
                Collections.reverse(integers);
                map.put(key ,integers);
            }
        }
        return new ArrayList<>(map.values());
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
