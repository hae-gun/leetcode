package org.example.week13;

import java.util.*;

public class LeetCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Set<TreeNode> set = new HashSet();
        if (root == null) return result;

        if(root.left == null && root.right == null){
            result.add(root.val);
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null && !set.contains(cur.left)){
                stack.add(cur);
                stack.add(cur.left);
                continue;
            }else{
                result.add(cur.val);
                set.add(cur);
                if(cur.right != null && !set.contains(cur.right)){
                    stack.add(cur.right);
                }
            }
        }
        return result;
    }
}
