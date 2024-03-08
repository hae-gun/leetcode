package org.example.week14;

import org.example.week13.TreeNode;

public class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null){
            return true;
        }
        if((p!=null && q == null) || (p==null && q!=null)){
            return false;
        }
        if(p != null && q != null){
            if(p.val != q.val) return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
