package org.example.week18;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode116 {
    Map<Integer, List<Node>> map = new HashMap<>();

    public Node connect(Node root) {
        if(root == null) return root;
        bfs(root, 0);

        for(Integer level : map.keySet()){
            List<Node> nodes = map.get(level);
            for (int i = 0; i < nodes.size()-1; i++) {
                nodes.get(i).next = nodes.get(i+1);
            }
        }

        return root;
    }

    void bfs (Node node, int level){
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<Node>());
        }
        map.get(level).add(node);
        // System.out.println(node.val);
        if(node.left != null) bfs(node.left, level+1);
        if(node.right != null) bfs(node.right, level+1);
    }
}
